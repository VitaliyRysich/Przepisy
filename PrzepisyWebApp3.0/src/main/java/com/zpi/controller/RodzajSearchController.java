package com.zpi.controller;

import com.zpi.dts.RodzajProduktyDts;
import com.zpi.entity.Produkt;
import com.zpi.entity.Rodzaj;
import com.zpi.service.ProduktService;
import com.zpi.service.RodzajService;
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
public class RodzajSearchController {
    @Autowired
    private RodzajService rodzajService;
    @Autowired
    private ProduktService produktService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/rodzaj/all", method = RequestMethod.GET)
    public ResponseEntity<List<Rodzaj>> getAllRodzaj(){
        List<Rodzaj> rodzajList = rodzajService.getAllRodzaj();
        return new ResponseEntity<List<Rodzaj>>(rodzajList, HttpStatus.OK);
    }


    /**
     * rodzaj i wszystkie produkty
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/rodprod", method = RequestMethod.GET)
    public ResponseEntity<List<RodzajProduktyDts>> getAllRodzajAndProdukts(){
        List<RodzajProduktyDts> rodzajProduktyDtsList = rodzajService.getAllProduktyDts();
        return new ResponseEntity<List<RodzajProduktyDts>>(rodzajProduktyDtsList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/rp/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produkt>> getProdukts(@PathVariable("id") long id){
        List<Produkt> produktList = produktService.getProduktsByRodzaj(id);
        return new ResponseEntity<List<Produkt>>(produktList, HttpStatus.OK);
    }


}
