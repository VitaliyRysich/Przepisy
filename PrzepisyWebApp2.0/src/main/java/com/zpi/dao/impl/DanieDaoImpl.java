package com.zpi.dao.impl;

import com.zpi.dao.DanieDao;
import com.zpi.entity.Danie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dima on 3/24/17.
 */
@Component
public class DanieDaoImpl implements DanieDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Danie> getAllDanie() {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Danie");
        List list=query.list();
        return list;
    }


    @Override
    public Danie getDanieById(long id) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Danie where id= :id");
        query.setLong("id",id);
        Danie userDetails = (Danie)query.uniqueResult();
        return userDetails;
    }


    public List<Danie> getDanieByName(String nazwa) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from com.zpi.entity.Danie where nazwa_danie like :nazwa");
        query.setString("nazwa", "%"+nazwa+"%");
        List list = query.list();
        return list;
    }

}
