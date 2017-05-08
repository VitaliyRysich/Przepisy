package com.zpi.controller;

import com.zpi.dto.PrzepisDto;
import com.zpi.mapper.PrzepisMapper;
import com.zpi.service.PrzepisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vitalii on 01.04.2017.
 */
@Controller
public class PrzepisSearchController {
    @Autowired
    private PrzepisMapper przepisMapper;
    @Autowired
    private PrzepisService przepisService;

    /**
     * Zwraca przepis według id przepisu
     *
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/przepis/{id}",method = RequestMethod.GET)
    public ResponseEntity<PrzepisDto> getPrzepisById(@PathVariable("id") long id) {
        PrzepisDto przepisDto = przepisMapper.toPrzepisDto(przepisService.getPrzepisById(id));
        return new ResponseEntity<PrzepisDto>(przepisDto, HttpStatus.OK);
    }
}
