package com.sshlearn.dao;

import com.sshlearn.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkmanDaoImpl extends HibernateDaoSupport implements LinkmanDao {
    //保存联系人
    public void save(Linkman linkman) {
        this.getHibernateTemplate().save(linkman);
    }

    public List<Linkman> findByCriteria(DetachedCriteria criteria) {
        List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
}