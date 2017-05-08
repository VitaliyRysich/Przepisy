package com.zpi.dao.impl;

import com.zpi.dao.TypDao;
import com.zpi.entity.Danie;
import com.zpi.entity.Typ;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vitalii on 27.03.2017.
 */

@Component
public class TypDaoImpl implements TypDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Typ> getAllTyp() {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Typ");
        List list=query.list();
        session.close();
        return list;
    }

    @Override
    public Typ getTypById(long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from com.zpi.entity.Typ where id= :id");
        query.setLong("id",id);
        Typ typ = (Typ)query.uniqueResult();
        session.close();
        return typ;
    }

    @Override
    public List<Typ> getIdByNazwa(String nazwa) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" select t.idTyp from com.zpi.entity.Typ t where t.nazwaTyp like :nazwa");
        query.setString("nazwa", "%"+nazwa+"%");
        List list = query.list();
        session.close();
        return list;

    }


}
