package com.zpi.controller;

import com.zpi.entity.Danie;
import com.zpi.service.DanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dima on 3/24/17.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private DanieService danieService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Danie>> getAllDanie() {
        List<Danie> listDanie = danieService.getAllDanie();
        return new ResponseEntity<List<Danie>>(listDanie,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getid-{id}",method = RequestMethod.GET)
    public ResponseEntity<Danie> getDanieByID(@PathVariable("id") long id) {
        Danie danie = danieService.getDanieById(id);
        return new ResponseEntity<Danie>(danie,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/get-name-{name1}", method = RequestMethod.GET)
    public ResponseEntity<List<Danie>> getDanieByName(@PathVariable("name1") String name) {
        List<Danie> listDanieName = danieService.getDanieByName(name);
        return new ResponseEntity<List<Danie>>(listDanieName, HttpStatus.OK);

    }
}
