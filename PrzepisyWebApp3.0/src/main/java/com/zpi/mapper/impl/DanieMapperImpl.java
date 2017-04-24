package com.zpi.mapper.impl;

import com.zpi.dto.DanieDto;
import com.zpi.entity.Danie;
import com.zpi.mapper.DanieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 3/30/17.
 */
@Service
public class DanieMapperImpl implements DanieMapper {

/*    @Autowired
    private DanieDto danieDto;*/

    @Override
    public DanieDto toDanieDto(Danie danie) {
        DanieDto danieDto = new DanieDto();
        danieDto.setIdDanie(danie.getIdDanie());
        danieDto.setIdPrzepis(danie.getIdPrzepis());
        danieDto.setZdjecieDanie(danie.getZdjecieDanie());
        danieDto.setIdTyp(danie.getIdTyp());
        danieDto.setNazwaDanie(danie.getNazwaDanie());
        danieDto.setOpisDanie(danie.getOpisDanie());
        return danieDto;
    }

    @Override
    public List<DanieDto> toDanieDtoList(List<Danie> danieList) {
        List<DanieDto> danieDtoList = new ArrayList<>();
        for(Danie tmpDanie: danieList) {
            danieDtoList.add(toDanieDto(tmpDanie));
        }
        return danieDtoList;
    }
}
