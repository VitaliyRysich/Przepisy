package com.zpi.controller;

import com.zpi.assembler.DanieAssembler;
import com.zpi.dao.ProduktDao;
import com.zpi.dao.ZawieraDao;
import com.zpi.dto.*;
import com.zpi.dts.AdvDanieDts;
import com.zpi.dts.DanieDts;
import com.zpi.entity.Danie;
import com.zpi.mapper.DanieMapper;
import com.zpi.mapper.PrzepisMapper;
import com.zpi.mapper.TypMapper;
import com.zpi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 3/24/17.
 */

@Controller
public class DanieSearchController {

    @Autowired
    private DanieService danieService;
    @Autowired
    private TypService typService;
    @Autowired
    private PrzepisService przepisService;
    @Autowired
    private DanieMapper danieMapper;
    @Autowired
    private TypMapper typMapper;
    @Autowired
    private DanieAssembler danieAssembler;
    @Autowired
    private PrzepisMapper przepisMapper;

    @Autowired
    private ZawieraDao zawieraDao;

    @Autowired
    private ProduktDao produktDao;



    /**
     *Zwraca listę dań(bez DTS)
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/danie/all",method = RequestMethod.GET)
    public ResponseEntity<List<Danie>> getAllDanie() {
        List<Danie> listDanie = danieService.getAllDanie();
        return new ResponseEntity<List<Danie>>(listDanie,HttpStatus.OK);
    }

    /**
     *Zwraca danie według nazwy
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/danieName/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<DanieDto>> getDanieByName(@PathVariable("name") String name) {
        List<Danie> listDanieName = danieService.getDanieByName(name);
        List<DanieDto> listDanieDto = danieMapper.toDanieDtoList(listDanieName);
        return new ResponseEntity<List<DanieDto>>(listDanieDto, HttpStatus.OK);
    }


    /**
     *Zwraca danie według id dania
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/danie/{id}",method = RequestMethod.GET)
    public ResponseEntity<DanieDts> getAllDanieById(@PathVariable("id") long id) {
        DanieDto danieDto = danieMapper.toDanieDto(danieService.getDanieById(id));
        TypDto typDto = typMapper.toTypDto(typService.getTypById(danieDto.getIdTyp()));
        PrzepisDto przepisDto = przepisMapper.toPrzepisDto(przepisService.getPrzepisById(danieDto.getIdPrzepis()));
        DanieDts danieDts = danieAssembler.toDanieAssembler(danieDto,typDto,przepisDto);
        return new ResponseEntity<DanieDts>(danieDts,HttpStatus.OK);
    }

    /**
     * Metoda przyjmuje Obiekt JSON i zwraca go
     */
    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/send/test", method = RequestMethod.POST)
    public ResponseEntity<ReqOb> getJSON(@RequestBody ReqOb reqOb) {
        reqOb.setCena(23424);

        return new ResponseEntity<ReqOb>(reqOb,HttpStatus.OK);
    }

    /**
     * Metoda przyjmuje Obiekt JSON i zwraca go
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/send/test1", method = RequestMethod.POST)
    public ResponseEntity<List<Danie>> getJSON1(@RequestBody ReqOb reqOb) {
        reqOb.setCena(23424);
        List<Danie> danieList = danieService.getDanieByTyp(reqOb.getNazwaTyp());

        return new ResponseEntity<List<Danie>>(danieList,HttpStatus.OK);
    }


    /**
     * Metoda przyjmuje Obiekt JSON i zwraca go
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/send/test2", method = RequestMethod.POST)
    public ResponseEntity<List<AdvDanieDts>> getJSON2(@RequestBody ReqOb reqOb) {
        List<AdvDanieDts> danieRez = danieService.getSortDanie(reqOb);
        return new ResponseEntity<List<AdvDanieDts>>(danieRez,HttpStatus.OK);
    }


    /**
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/send/test3", method = RequestMethod.POST)
    public ResponseEntity<List<AdvDanieDts>> newRecord(@RequestBody NewDBRecords newDBRecords) {

        //List<AdvDanieDts> danieRez = danieService.getSortDanie(reqOb);
        //return new ResponseEntity<List<AdvDanieDts>>(danieRez,HttpStatus.OK);
        return null;
    }
}
