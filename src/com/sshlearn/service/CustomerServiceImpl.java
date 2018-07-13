package com.sshlearn.service;

import com.sshlearn.dao.CustomerDao;
import com.sshlearn.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * customer业务层
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    //注入customer持久层
    private CustomerDao customerDao;
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 保存客户
     * @param customer
     */
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    /**
     * 按条件查询
     * @return
     */
    public List<Customer> findByCriteria(DetachedCriteria criteria) {
        return customerDao.findByCriteria(criteria);
    }
}
