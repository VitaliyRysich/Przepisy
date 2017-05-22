package com.zpi.controller;

import com.zpi.dto.NewDBRecords;
import com.zpi.dto.PrzepisDto;
import com.zpi.dts.AdvDanieDts;
import com.zpi.mapper.PrzepisMapper;
import com.zpi.service.PrzepisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    /**
     * test
     *
     * */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/testnp",method = RequestMethod.POST)
    public ResponseEntity<Integer> newRecord(@RequestBody NewDBRecords newDBRecords) {
        przepisService.insertPrzepis(newDBRecords);
        return new ResponseEntity<Integer>(2, HttpStatus.OK);
    }
}
