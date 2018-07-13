package com.sshlearn.service;

import com.sshlearn.domain.Customer;
import com.sshlearn.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkmanService {

    //保存联系人
    public void save(Linkman linkman, Customer customer);
    public List<Linkman> findByCriteria(DetachedCriteria criteria);
}
