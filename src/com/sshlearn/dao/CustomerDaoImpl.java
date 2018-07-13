package com.sshlearn.dao;

import com.sshlearn.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;


public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    public List<Customer> findByCriteria(DetachedCriteria criteria) {
        List<Customer> list =(List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

}
