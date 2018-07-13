package com.sshlearn.service;

import com.sshlearn.dao.LinkmanDao;
import com.sshlearn.domain.Customer;
import com.sshlearn.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {
    //注入Linkman的持久层
    private LinkmanDao linkmanDao;
    public void setLinkmanDao(LinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    //保存联系人
    public void save(Linkman linkman, Customer customer) {
        linkman.setCustomer(customer);
        linkmanDao.save(linkman);
    }

    public List<Linkman> findByCriteria(DetachedCriteria criteria) {
        return linkmanDao.findByCriteria(criteria);
    }


}
