package com.sshlearn.dao;

import com.sshlearn.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkmanDao {
    //保存联系人
    public void save(Linkman linkman);

    List<Linkman> findByCriteria(DetachedCriteria criteria);
}
