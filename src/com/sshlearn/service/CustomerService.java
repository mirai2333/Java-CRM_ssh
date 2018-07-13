package com.sshlearn.service;

import com.sshlearn.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {

    public void save(Customer customer);

    List<Customer> findByCriteria(DetachedCriteria criteria);
}
