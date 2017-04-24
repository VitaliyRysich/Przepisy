package com.zpi.assembler.impl;

import com.zpi.assembler.ProduktInDanieAssembler;
import com.zpi.dts.ProduktInDanieDts;
import com.zpi.entity.Produkt;
import com.zpi.entity.Zawiera;
import com.zpi.service.ProduktService;
import com.zpi.service.impl.ProduktServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Service
public class ProduktInDanieAssemblerImpl implements ProduktInDanieAssembler{
    @Autowired
    ProduktService produktService;

    @Override
    public List<ProduktInDanieDts> toProduktInDanieDtsList(List<Zawiera> zawieraList) {
        List<ProduktInDanieDts> list = new ArrayList<>();

        for (Zawiera zawiera: zawieraList) {
           // ProduktService produktService = new ProduktServiceImpl();
            Produkt produkt = produktService.getProduktById(zawiera.getIdProdukt());
            ProduktInDanieDts produktInDanieDts = new ProduktInDanieDts();

            produktInDanieDts.setIdProdukt(zawiera.getIdProdukt());
            produktInDanieDts.setIlosc(zawiera.getIlosc());
            produktInDanieDts.setNazwaProdukt(produkt.getNazwaProdukt());
            produktInDanieDts.setWartosc(produkt.getCenaProdukt());

            list.add(produktInDanieDts);
        }

        return list;
    }
}
