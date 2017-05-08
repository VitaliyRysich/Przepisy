package com.zpi.controller;

import com.zpi.dao.ProduktDao;
import com.zpi.dao.ZawieraDao;
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
public class ZawieraSearchController {
    @Autowired
    private ZawieraService zawieraService;

    @Autowired
    private ZawieraDao zawieraDao;

    /**
     * Get all zawiera(bez DTO)
     *
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/zawiera/all",method = RequestMethod.GET)
    public ResponseEntity<List<Zawiera>> getAllZawiera() {
        List<Zawiera> listZawiera = zawieraService.getAllZawiera();
        return new ResponseEntity<List<Zawiera>>(listZawiera , HttpStatus.OK);
    }


    /**
     *
     *  TMP Controller
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/zawiera/{id1}/{id2}",method = RequestMethod.GET)
    public ResponseEntity<Long> getAllZawiera(@PathVariable("id1") long id1, @PathVariable("id2") long id2) {
        long rez = zawieraDao.getRezult(id1,id2);
        return new ResponseEntity<Long>(rez , HttpStatus.OK);
    }


    /**
     *
     * TMP Controller
     * */
    @RequestMapping(value = "/zawieraProd/{id1}",method = RequestMethod.GET)
    public ResponseEntity<Long> getSumProd(@PathVariable("id1") long id1) {
        long rez = zawieraDao.getSumProd(id1);
        return new ResponseEntity<Long>(rez , HttpStatus.OK);
    }
}
