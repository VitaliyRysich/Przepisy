package com.zpi.service.impl;

import com.zpi.dao.ProduktDao;
import com.zpi.dao.RodzajDao;
import com.zpi.dts.RodzajProduktyDts;
import com.zpi.entity.Produkt;
import com.zpi.entity.Rodzaj;
import com.zpi.service.RodzajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Service
public class RodzajServiceImpl implements RodzajService {

    @Autowired
    RodzajDao rodzajDao;
    @Autowired
    ProduktDao produktDao;

    @Override
    public List<Rodzaj> getAllRodzaj() {
        return rodzajDao.getAllRodzaj();
    }

    @Override
    public List<RodzajProduktyDts> getAllProduktyDts() {
        List<RodzajProduktyDts> rodzajProduktyDtsList = new ArrayList<>();
        List<Rodzaj> rodzajList = rodzajDao.getAllRodzaj();
        for(Rodzaj r: rodzajList){
            RodzajProduktyDts rp = new RodzajProduktyDts();
            rp.setNazwaRodzaj(r.getNazwaRodzaj());
            List<Produkt> produktList = produktDao.getProduktsByRodzaj(r.getIdRodzaj());
            List<String> listOfProduktName = new ArrayList<>();
            for(Produkt p: produktList){
                listOfProduktName.add(p.getNazwaProdukt());
            }
            rp.setProduktList(listOfProduktName);
            rodzajProduktyDtsList.add(rp);
        }
         return rodzajProduktyDtsList;
    }
}
