package com.zpi.mapper.impl;

import com.zpi.dto.PrzepisDto;
import com.zpi.entity.Przepis;
import com.zpi.mapper.PrzepisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dima on 3/30/17.
 */
@Service
public class PrzepisMapperImpl implements PrzepisMapper {

    @Autowired
    PrzepisDto przepisDto;

    @Override
    public PrzepisDto toPrzepisDto(Przepis przepis) {
        this.przepisDto.setIdPrzepis(przepis.getIdPrzepis());
        this.przepisDto.setOpisPrzepis(przepis.getOpisPrzepis());
        this.przepisDto.setCzasPrzepis(przepis.getCzasPrzepis());
        return przepisDto;
    }
}
