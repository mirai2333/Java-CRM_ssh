package com.sshlearn.web.action;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sshlearn.domain.Customer;
import com.sshlearn.service.CustomerService;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //封装数据
    private Customer customer = new Customer();
    public Customer getModel() {
        return customer;
    }

    //注入customerService
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    /**
     * Action创建离线查询条件，findAction执行查询动作并封装好数据
     * @param criteria
     */
    private void findAction(DetachedCriteria criteria){
        //根据条件查询，得到返回的list集合
        List<Customer> list = customerService.findByCriteria(criteria);

        Type typeOfSrc = new TypeToken<List<Customer>>(){}.getType();
        String customerJson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(list,typeOfSrc);
        customerJson = "{\"code\":0,\"msg\":\"\",\"count\":11,\"data\":"+customerJson+"}";
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().write(customerJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存客户
     * @return
     */
    public String save(){
        customerService.save(customer);
        return "list";
    }

    /**
     * 查询所有客户
     * @return
     */
    public String findAllCustomer(){
        String customerName = customer.getCust_name();
        DetachedCriteria criteria;
        if (customerName != null && !"".equals(customerName)){
            criteria = DetachedCriteria.forClass(Customer.class).add(Restrictions.like("cust_name","%"+customerName+"%"));
        }else{
            criteria = DetachedCriteria.forClass(Customer.class);

        }
        findAction(criteria);
        return NONE;
    }


}
