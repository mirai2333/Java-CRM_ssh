package com.sshlearn.web.action;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sshlearn.domain.Customer;
import com.sshlearn.domain.Linkman;
import com.sshlearn.service.CustomerService;
import com.sshlearn.service.LinkmanService;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

    //数据封装
    private Linkman linkman = new Linkman();
    public Linkman getModel() {
        return linkman;
    }
    //属性驱动的数据封装
    private Long cust_id;
    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }
    //注入Customer的业务层，用来查询所有客户
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    //注入Linkman的业务层
    private LinkmanService linkmanService;
    public void setLinkmanService(LinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }


    /**
     * Action创建离线查询条件，findAction执行查询动作并封装好数据
     * @param criteria
     */
    private void findAction(DetachedCriteria criteria){
        //根据条件查询，得到返回的list集合
        List<Linkman> list = linkmanService.findByCriteria(criteria);
        Type typeOfSrc = new TypeToken<List<Linkman>>(){}.getType();
        String linkmanJson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(list,typeOfSrc);
        linkmanJson = "{\"code\":0,\"msg\":\"\",\"count\":11,\"data\":"+linkmanJson+"}";
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().write(linkmanJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //保存联系人
    public String save(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class).add(Restrictions.eq("cust_id",cust_id));
        Customer customer = customerService.findByCriteria(criteria).get(0);
        linkmanService.save(linkman,customer);
        return "list";
    }

    //查询所有客户，为下拉选择框提供选项
    public String findAllCustomer(){
        //提供离线条件并查询
        List<Customer> customers = customerService.findByCriteria(DetachedCriteria.forClass(Customer.class));
        ServletActionContext.getRequest().setAttribute("list",customers);
        return "add";
    }
    //查询所有联系人
    public String findAllLinkman(){
        String linkmanName = linkman.getLkmName();
        DetachedCriteria criteria;
        if (linkmanName != null && !"".equals(linkmanName)){
            criteria = DetachedCriteria.forClass(Linkman.class).add(Restrictions.like("lkmName","%"+linkmanName+"%"));
        }else
            criteria = DetachedCriteria.forClass(Linkman.class);
        findAction(criteria);
        return NONE;
    }
}
