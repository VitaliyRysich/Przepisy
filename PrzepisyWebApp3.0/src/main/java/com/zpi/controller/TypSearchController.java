package com.zpi.controller;

import com.zpi.dto.TypDto;
import com.zpi.entity.Typ;
import com.zpi.mapper.TypMapper;
import com.zpi.service.TypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Vitalii on 01.04.2017.
 */
public class TypSearchController {
    @Autowired
    private TypService typService;
    @Autowired
    private TypMapper typMapper;

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
}
