package com.zpi.service.impl;

import com.zpi.dao.DanieDao;
import com.zpi.dao.ProduktDao;
import com.zpi.dao.ZawieraDao;
import com.zpi.dto.ReqOb;
import com.zpi.dts.AdvDanieDts;
import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;
import com.zpi.entity.Zawiera;
import com.zpi.service.DanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 3/21/17.
 */
@Service
public class DanieServiceImpl implements DanieService{

    @Autowired
    private DanieDao danieDao;

    @Autowired
    private ZawieraDao zawieraDao;

    @Autowired
    private ProduktDao produktDao;

    @Override
    public List<Danie> getAllDanie() {
        return danieDao.getAllDanie();
    }

    @Override
    public Danie getDanieById(long id) {
        return danieDao.getDanieById(id);
    }

    @Override
    public Danie getDanieById2(long id) {
        return danieDao.getDanieById2(id);
    }

    @Override
    public List<Danie> getDanieByName(String name){
        return danieDao.getDanieByName(name);
    }

    @Override
    public List<Danie> getDanieByTyp(String typ) {
        List<Danie> danieList = danieDao.getDanieByTyp(typ);
        return danieDao.getDanieByTyp(typ);
    }

    @Override
    public List<AdvDanieDts> getSortDanie(ReqOb reqOb) {

        List<Danie> danieList = danieDao.getDanieByTyp(reqOb.getNazwaTyp());
        List<Danie> danieRez = new ArrayList<Danie>();

        List<AdvDanieDts> advDanieDtsList = new ArrayList<>();

        for(Danie d: danieList) {
            List<Produkt> tmpList = new ArrayList<>();
            long tmpSize = zawieraDao.getSumProd(d.getIdDanie());
            String [] tmpArr = reqOb.getProdukty();
            long sizeProd =0;
            tmpList.clear();
            for(String str : tmpArr) {
                Produkt tmpProd = produktDao.getProduktByName(str);
                if(zawieraDao.getRezult(d.getIdDanie(),tmpProd.getIdProdukt()) == 1) {
                    sizeProd++;
                    tmpList.add(tmpProd);
                }
            }

            double tmpd = (double)sizeProd/(double)tmpSize;
            System.out.println(tmpd);
            if(tmpd >= 0.5) {
                danieRez.add(d);
                AdvDanieDts advDanieDts = new AdvDanieDts(d);
                advDanieDts.setIsIn(tmpList);
                advDanieDts.setOcena(tmpd);
                advDanieDtsList.add(advDanieDts);
            }
        }
        for(AdvDanieDts ad: advDanieDtsList) {
            ad.setIsNotIn(getIsNotInProdukt(getAllProdukt(ad.getIdDanie()),ad.getIsIn()));
        }

        for(AdvDanieDts ad: advDanieDtsList) {
            ad.setSumaDoplaty(sumaDoplaty(ad.getIsNotIn()));
        }

        advDanieDtsList=removeByCena(advDanieDtsList, reqOb.getCena());


        return advDanieDtsList;
    }

    public List<Produkt> getAllProdukt(long idDania) {

        List<Zawiera> zawieraList = new ArrayList<>();
        List<Produkt> produktList = new ArrayList<>();
        zawieraList = zawieraDao.getAllZawieraByIdDanie(idDania);
        for(Zawiera z:zawieraList) {
            produktList.add(produktDao.getProduktById(z.getIdProdukt()));
        }

        return produktList;
    }

    public List<Produkt> getIsNotInProdukt(List<Produkt> allProduktList, List<Produkt> isInReq) {
        List<Produkt> rezList = new ArrayList<>();
        List<Produkt> tmp = new ArrayList<>();
        rezList.addAll(allProduktList);


        System.out.println(rezList.toString());
        for(Produkt p2:rezList) {
            for(Produkt p1:isInReq) {
                if(p2.getIdProdukt()==p1.getIdProdukt())
                    tmp.add(p2);
            }
        }

        rezList.removeAll(tmp);
        System.out.println("====================");
        System.out.println(rezList.toString());

        return rezList;
    }

    public double sumaDoplaty(List<Produkt> list) {
        double tmpOcena=0;
        for (Produkt p: list) {
            tmpOcena += p.getCenaProdukt();
        }
        return tmpOcena;
    }

    public List<AdvDanieDts> removeByCena(List<AdvDanieDts> list, double cena) {
        List<AdvDanieDts> tmp = new ArrayList<>();

        for (AdvDanieDts ad:list) {
            if(ad.getSumaDoplaty() > cena)
                tmp.add(ad);
        }
        list.removeAll(tmp);
        return list;
    }
}
