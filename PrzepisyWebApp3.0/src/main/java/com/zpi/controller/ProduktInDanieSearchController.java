package com.zpi.controller;

import com.zpi.assembler.ProduktInDanieAssembler;
import com.zpi.dao.ProduktDao;
import com.zpi.dts.ProduktInDanieDts;
import com.zpi.entity.Produkt;
import com.zpi.entity.Zawiera;
import com.zpi.service.ZawieraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Vitalii on 01.04.2017.
 */
@Controller
public class ProduktInDanieSearchController {
    @Autowired
    private ZawieraService zawieraService;
    @Autowired
    private ProduktInDanieAssembler produktInDanieAssembler;

    @Autowired
    private ProduktDao produktDao;

    /**
     * Zwraca wszystkie produkty w daniu
     * według id dania
     *
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/produktIdDania/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<ProduktInDanieDts>> getAllProduktByIdDanie(@PathVariable("id") long id) {
        List<Zawiera> listZawiera = zawieraService.getAllZawieraByIdDanie(id);
        List<ProduktInDanieDts> listProd= produktInDanieAssembler.toProduktInDanieDtsList(listZawiera);
        return new ResponseEntity<List<ProduktInDanieDts>>(listProd , HttpStatus.OK);
    }


    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/prod/{name}",method = RequestMethod.GET)
    public ResponseEntity<Produkt> getIdByName(@PathVariable("name") String name) {
        Produkt produkt = produktDao.getProduktByName(name);
        return new ResponseEntity<Produkt>(produkt , HttpStatus.OK);
    }
}
