package com.zpi.dao.impl;

import com.zpi.dao.ObjectInsertDao;
import com.zpi.dao.ProduktDao;
import com.zpi.dao.TypDao;
import com.zpi.dao.ZawieraDao;
import com.zpi.dto.NewDBRecords;
import com.zpi.dto.ProduktNazwaIlosc;
import com.zpi.entity.Danie;
import com.zpi.entity.Przepis;
import com.zpi.entity.Zawiera;
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

    @Autowired
    private TypDao typDao;

    @Autowired
    private ZawieraDao zawieraDao;

    @Autowired
    private ProduktDao produktDao;

    @Override
    public void insertObject(NewDBRecords ob) {
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        Przepis przepis = new Przepis(ob.getOpisPrzepis(),ob.getCzasPrzepis());
        long idPrzep = (long)session.save(przepis);

        //Danie danie = new Danie(ob.getNazwaDanie(),ob.getOpisDanie(),ob.getZdjecieDanie(),ob.getNazwaTyp(),1);
        Danie danie = new Danie(ob.getNazwaDanie(),ob.getOpisDanie(),ob.getZdjecieDanie(),ob.getNazwaTyp(),idPrzep);
        long idDanie = (long)session.save(danie);

        for(ProduktNazwaIlosc pni : ob.getProdukty()) {
            long idProd = produktDao.getIdByNazwa(pni.getNazwaProdukt());
            Zawiera zawiera = new Zawiera(idDanie,idProd,pni.getIloscProdukt());
           // Zawiera zawiera = new Zawiera(1,2,"888888888888888");
            session.save(zawiera);
        }
        session.getTransaction().commit();
        session.close();
        /*Zawiera zawiera = new Zawiera(1,2,"888888888888888");
        session.save(zawiera);
        session.getTransaction().commit();
        session.close();
*/
        /*Session session2 =sessionFactory.openSession();
        session2.close(); */
    }
}
