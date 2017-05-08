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
        Query query=session.createQuery("select d from com.zpi.entity.Danie d");
        List list=query.list();
        session.close();
        return list;
    }


    @Override
    public Danie getDanieById(long id) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Danie where id= :id");
        query.setLong("id",id);
        Danie userDetails = (Danie)query.uniqueResult();
        session.close();
        return userDetails;
    }

    @Override
    public Danie getDanieById2(long id) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery(" from Danie d where IdTyp= :id");
        query.setLong("id",id);
        Danie userDetails = (Danie)query.uniqueResult();
        session.close();
        return userDetails;
    }


    public List<Danie> getDanieByName(String nazwa) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from com.zpi.entity.Danie where nazwa_danie like :nazwa");
        query.setString("nazwa", "%"+nazwa+"%");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Danie> getDanieByTyp(String typ) {
        Session session = sessionFactory.openSession();
        //Query query = session.createQuery("from com.zpi.entity.Danie where id_typ in (select id_typ from com.zpi.entity.Typ where nazwa_typ like :typ)");
        Query query = session.createQuery("select t.idTyp from com.zpi.entity.Typ t where t.nazwaTyp like :typ");
        query.setString("typ","%"+typ+"%");
        Query query1 = session.createQuery("from com.zpi.entity.Danie where id_typ in (:ids)").setParameterList("ids", query.list());

        List list = query1.list();
        session.close();
        return list;
    }

}
