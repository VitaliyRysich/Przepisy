package com.zpi.controller;

import com.zpi.assembler.DanieAssembler;
import com.zpi.assembler.ProduktInDanieAssembler;
import com.zpi.dto.DanieDto;
import com.zpi.dto.PrzepisDto;
import com.zpi.dto.TypDto;
import com.zpi.dts.DanieDts;
import com.zpi.dts.ProduktInDanieDts;
import com.zpi.entity.Danie;
import com.zpi.entity.Rodzaj;
import com.zpi.entity.Typ;
import com.zpi.entity.Zawiera;
import com.zpi.mapper.DanieMapper;
import com.zpi.mapper.PrzepisMapper;
import com.zpi.mapper.TypMapper;
import com.zpi.mapper.impl.DanieMapperImpl;
import com.zpi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
