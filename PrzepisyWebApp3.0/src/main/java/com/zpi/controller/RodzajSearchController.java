package com.zpi.controller;

import com.zpi.entity.Rodzaj;
import com.zpi.service.RodzajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/rodzaj/all", method = RequestMethod.GET)
    public ResponseEntity<List<Rodzaj>> getAllRodzaj(){
        List<Rodzaj> rodzajList = rodzajService.getAllRodzaj();
        return new ResponseEntity<List<Rodzaj>>(rodzajList, HttpStatus.OK);
    }
}
