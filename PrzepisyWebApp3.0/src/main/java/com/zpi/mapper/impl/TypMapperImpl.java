package com.zpi.mapper.impl;

import com.zpi.dao.TypDao;
import com.zpi.dto.TypDto;
import com.zpi.entity.Typ;
import com.zpi.mapper.TypMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 3/30/17.
 */
@Service
public class TypMapperImpl implements TypMapper{

    //@Autowired
    //private TypDto typDto;

    @Override
    public TypDto toTypDto(Typ typ) {
        TypDto typDto = new TypDto();
        typDto.setIdTyp(typ.getIdTyp());
        typDto.setNazwaTyp(typ.getNazwaTyp());
        return typDto;
    }

    @Override
    public List<TypDto> toTypDtoList(List<Typ> typList) {
        List<TypDto> typDtoList = new ArrayList<>();
        for(Typ typ:typList) {
            typDtoList.add(toTypDto(typ));
        }
        return typDtoList;
    }
}
