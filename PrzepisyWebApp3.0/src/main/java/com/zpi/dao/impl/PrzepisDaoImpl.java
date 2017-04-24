package com.zpi.dao.impl;

import com.zpi.dao.PrzepisDao;
import com.zpi.entity.Danie;
import com.zpi.entity.Przepis;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dima on 3/30/17.
 */
@Component
public class PrzepisDaoImpl implements PrzepisDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Przepis getPrzepisById(long id) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Przepis where id= :id");
        query.setLong("id",id);
        Przepis przepis = (Przepis) query.uniqueResult();
        session.close();
        return przepis;
    }
}
