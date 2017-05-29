package com.zpi.dao.impl;

import com.zpi.dao.ObjectInsertDao;
import com.zpi.dto.NewDBRecords;
import com.zpi.entity.Danie;
import com.zpi.entity.Przepis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 22.05.2017.
 */
@Component
public class ObjectInsertDaoImpl implements ObjectInsertDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertObject(NewDBRecords ob) {
        Session session =sessionFactory.openSession();
        Przepis przepis = new Przepis(ob.getOpisPrzepis(),ob.getCzasPrzepis());
        long idPrzep = (long)session.save(przepis);

        session.close();

        Session session2 =sessionFactory.openSession();

        Danie danie = new Danie(ob.getNazwaDanie(),ob.getOpisDanie(),ob.getZdjecieDanie(),ob.getIdTyp(),idPrzep);
        long idDanie = (long)session2.save(danie);
        session2.close();
    }
}
