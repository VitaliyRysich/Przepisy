package com.zpi.dao.impl;

import com.zpi.dao.ProduktDao;
import com.zpi.entity.Produkt;
import com.zpi.entity.Typ;
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

    @Override
    public Produkt getProduktByName(String name) {
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Produkt where  nazwa_produkt= :name");
        query.setString("name",name);
        Produkt userDetails = (Produkt) query.uniqueResult();

        session.close();
        return userDetails;
    }

    @Override
    public List<Produkt> getProduktsByRodzaj(long id) {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from com.zpi.entity.Produkt where idRodzaj= :id");
        query.setLong("id",id);
        List list=query.list();
        session.close();
        return list;
    }

    @Override
    public Long getIdByNazwa(String nazwa) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from com.zpi.entity.Produkt t where t.nazwaProdukt like :nazwa");
        query.setString("nazwa", "%"+nazwa+"%");
        List<Produkt> list = query.list();
        //Typ tmpTyp = (Typ) query.uniqueResult();
        Produkt tmpTyp = list.get(0);
        session.close();
        return tmpTyp.getIdProdukt();
    }


}
