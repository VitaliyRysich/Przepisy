package com.zpi.controller;

import com.zpi.dao.TypDao;
import com.zpi.dto.TypDto;
import com.zpi.entity.Typ;
import com.zpi.mapper.TypMapper;
import com.zpi.service.TypService;
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
public class TypSearchController {
    @Autowired
    private TypService typService;
    @Autowired
    private TypMapper typMapper;

    @Autowired
    private TypDao typDao;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getTyp-all",method = RequestMethod.GET)
    public ResponseEntity<List<TypDto>> getAllTyp() {
        List<Typ> listTyp = typService.getAllTyp();
        List<TypDto> typDtoList = typMapper.toTypDtoList(listTyp);
        return new ResponseEntity<List<TypDto>>(typDtoList, HttpStatus.OK);
    }

    /**
     * Zwraca typ według id
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/typ/{id}",method = RequestMethod.GET)
    public ResponseEntity<TypDto> getTypById(@PathVariable("id") long id) {
        TypDto typDto = typMapper.toTypDto(typService.getTypById(id));
        return new ResponseEntity<TypDto>(typDto,HttpStatus.OK);
    }


    /**
     *Zwraca danie według nazwy
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/typName/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Typ>> getDanieByName(@PathVariable("name") String name) {
        List<Typ> list = typService.getTypByNazwa(name);
        return new ResponseEntity<List<Typ>>(list,HttpStatus.OK);
        //List<Danie> listDanieName = danieService.getDanieByName(name);
        //List<DanieDto> listDanieDto = danieMapper.toDanieDtoList(listDanieName);
        //return new ResponseEntity<List<DanieDto>>(listDanieDto, HttpStatus.OK);
    }

    /**
     *Zwraca ID według nazwy
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/IdtypName/{name}", method = RequestMethod.GET)
    public ResponseEntity<Long> getIdByName(@PathVariable("name") String name) {
        Long id = typService.getIdByNazwa(name);
        //List<Typ> list = typService.getTypByNazwa(name);
        return new ResponseEntity<Long>(id,HttpStatus.OK);
        //List<Danie> listDanieName = danieService.getDanieByName(name);
        //List<DanieDto> listDanieDto = danieMapper.toDanieDtoList(listDanieName);
        //return new ResponseEntity<List<DanieDto>>(listDanieDto, HttpStatus.OK);
    }


    /**
     *Zwraca ID insertu typu
     *
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/setTyp", method = RequestMethod.GET)
    public ResponseEntity<Long> setTyp() {
        long id = typDao.seTyp(35,"Name2");
        //List<Typ> list = typService.getTypByNazwa(name);
        //return new ResponseEntity<Long>(id,HttpStatus.OK);
        return new ResponseEntity<Long>(id,HttpStatus.OK);
    }


}
