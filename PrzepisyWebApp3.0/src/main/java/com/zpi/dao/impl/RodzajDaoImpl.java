package com.zpi.dao.impl;

import com.zpi.dao.RodzajDao;
import com.zpi.entity.Rodzaj;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Component
public class RodzajDaoImpl implements RodzajDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Rodzaj> getAllRodzaj() {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Rodzaj");
        List list = query.list();
        session.close();
        return list;
    }
}
