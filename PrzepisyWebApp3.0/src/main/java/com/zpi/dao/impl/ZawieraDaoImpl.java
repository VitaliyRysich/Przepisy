package com.zpi.dao.impl;

import com.zpi.dao.ZawieraDao;
import com.zpi.entity.Zawiera;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Component
public class ZawieraDaoImpl implements ZawieraDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Zawiera> getAllZawiera() {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Zawiera");
        List list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<Zawiera> getAllZawieraByIdDanie(long id) {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Zawiera where idDanie= :id");
        query.setLong("id",id);
        List<Zawiera> list=query.list();
        session.close();
        return list;
    }
}
