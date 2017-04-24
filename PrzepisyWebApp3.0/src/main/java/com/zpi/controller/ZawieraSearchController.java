package com.zpi.controller;

import com.zpi.entity.Zawiera;
import com.zpi.service.ZawieraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Vitalii on 01.04.2017.
 */
public class ZawieraSearchController {
    @Autowired
    private ZawieraService zawieraService;

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
}
