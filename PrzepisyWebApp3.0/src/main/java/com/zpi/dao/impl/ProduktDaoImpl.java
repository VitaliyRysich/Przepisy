package com.zpi.dao.impl;

import com.zpi.dao.ProduktDao;
import com.zpi.entity.Produkt;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Component
public class ProduktDaoImpl implements ProduktDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Produkt getProduktById(long id) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Produkt where id= :id");
        query.setLong("id",id);
        Produkt userDetails = (Produkt) query.uniqueResult();
        session.close();
        return userDetails;
    }
}
