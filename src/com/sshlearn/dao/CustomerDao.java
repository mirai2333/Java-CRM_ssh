package com.sshlearn.dao;

import com.sshlearn.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {

    public void save(Customer customer);

    List<Customer> findByCriteria(DetachedCriteria criteria);
}
