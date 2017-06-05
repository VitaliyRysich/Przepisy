package com.zpi.service.impl;

import com.zpi.dao.DanieDao;
import com.zpi.dao.ProduktDao;
import com.zpi.dao.PrzepisDao;
import com.zpi.dao.ZawieraDao;
import com.zpi.dto.ProduktDtoAdv;
import com.zpi.dto.PrzepisDto;
import com.zpi.dto.ReqOb;
import com.zpi.dts.AdvDanieDts;
import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;
import com.zpi.entity.Przepis;
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

    @Autowired
    private PrzepisDao przepisDao;

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
            List<ProduktDtoAdv> tmpList = new ArrayList<>();
            List<Zawiera> tmpZawiera;

            long tmpSize = zawieraDao.getSumProd(d.getIdDanie());
            String [] tmpArr = reqOb.getProdukty();
            long sizeProd =0;
            tmpList.clear();
            for(String str : tmpArr) {
                ProduktDtoAdv produktDtoAdv = new ProduktDtoAdv();
                Produkt tmpProd = produktDao.getProduktByName(str);
                if(zawieraDao.getRezult(d.getIdDanie(),tmpProd.getIdProdukt()) == 1) {
                    sizeProd++;
                    tmpZawiera = zawieraDao.getAllZawieraByIdDanie(d.getIdDanie());
                    produktDtoAdv.setCenaProdukt(tmpProd.getCenaProdukt());
                    produktDtoAdv.setIdProdukt(tmpProd.getIdProdukt());
                    produktDtoAdv.setIdRodzaj(tmpProd.getIdRodzaj());
                    produktDtoAdv.setNazwaProdukt(tmpProd.getNazwaProdukt());
                    for(Zawiera zw: tmpZawiera) {
                        if(zw.getIdProdukt()== produktDtoAdv.getIdProdukt())
                            produktDtoAdv.setIlosc(zw.getIlosc());
                    }
                    tmpList.add(produktDtoAdv);
                }
            }

            long idPrzepis = d.getIdPrzepis();
            Przepis przepis = przepisDao.getPrzepisById(idPrzepis);

            double tmpd = (double)sizeProd/(double)tmpSize;
            danieRez.add(d);
            AdvDanieDts advDanieDts = new AdvDanieDts(d);
            advDanieDts.setIsIn(tmpList);
            advDanieDts.setOcena(tmpd);
            advDanieDts.setCzasPrzepis(przepis.getCzasPrzepis());
            advDanieDts.setOpisPrzepis(przepis.getOpisPrzepis());
            advDanieDts.setNazwaTyp(reqOb.getNazwaTyp());
            advDanieDtsList.add(advDanieDts);



            /*System.out.println(tmpd);
            if(tmpd >= 0.5) {

            }*/
        }
        for(AdvDanieDts ad: advDanieDtsList) {
            //ad.setIsNotIn(getIsNotInProdukt());
            ad.setIsNotIn(getIsNotInProdukt(getAllProdukt(ad.getIdDanie()),ad.getIsIn()));
        }

        for(AdvDanieDts ad: advDanieDtsList) {
            ad.setSumaDoplaty(sumaDoplaty(ad.getIsNotIn()));
        }

        advDanieDtsList=removeByCena(advDanieDtsList, reqOb.getCena());

        advDanieDtsList.sort(AdvDanieDts.ocenaComparator);
        return advDanieDtsList;
    }

    /*public List<Long> getIloscProdukt(long idDanie) {
        List<Zawiera> tmpZawiera = new ArrayList<>();
        tmpZawiera = zawieraDao.getAllZawieraByIdDanie(idDanie);
        List<Long> ls = new ArrayList<>();
        for(Zawiera zw: tmpZawiera){
            System.out.println(zw.getIdProdukt());
            ls.add(zw.getIdProdukt());
        }
        return ls;
    }*/

    public List<ProduktDtoAdv> getAllProdukt(long idDania) {

        List<Zawiera> zawieraList = new ArrayList<>();
        List<ProduktDtoAdv> produktList = new ArrayList<>();
        zawieraList = zawieraDao.getAllZawieraByIdDanie(idDania);
        for(Zawiera z:zawieraList) {
            Produkt tmpProd = produktDao.getProduktById(z.getIdProdukt());
            ProduktDtoAdv produktDtoAdv = new ProduktDtoAdv();
            produktDtoAdv.setCenaProdukt(tmpProd.getCenaProdukt());
            produktDtoAdv.setIdProdukt(tmpProd.getIdProdukt());
            produktDtoAdv.setIdRodzaj(tmpProd.getIdRodzaj());
            produktDtoAdv.setNazwaProdukt(tmpProd.getNazwaProdukt());
            if(z.getIdProdukt()== produktDtoAdv.getIdProdukt())
                produktDtoAdv.setIlosc(z.getIlosc());
            //produktDtoAdv.setIloscProdukt(z.getIloscProdukt());
            produktList.add(produktDtoAdv);
        }

        return produktList;
    }

    public List<ProduktDtoAdv> getIsNotInProdukt(List<ProduktDtoAdv> allProduktList, List<ProduktDtoAdv> isInReq) {
        List<ProduktDtoAdv> rezList = new ArrayList<>();
        List<ProduktDtoAdv> tmp = new ArrayList<>();
        rezList.addAll(allProduktList);


        System.out.println(rezList.toString());
        for(ProduktDtoAdv p2:rezList) {
            for(ProduktDtoAdv p1:isInReq) {
                if(p2.getIdProdukt()==p1.getIdProdukt())
                    tmp.add(p2);
            }
        }

        rezList.removeAll(tmp);
        //System.out.println("====================");
        //System.out.println(rezList.toString());

        return rezList;
    }

    public double sumaDoplaty(List<ProduktDtoAdv> list) {
        double tmpOcena=0;
        for (ProduktDtoAdv p: list) {
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
