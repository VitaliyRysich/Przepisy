package com.zpi.assembler.impl;

import com.zpi.assembler.DanieAssembler;
import com.zpi.dto.DanieDto;
import com.zpi.dto.PrzepisDto;
import com.zpi.dto.TypDto;
import com.zpi.dts.DanieDts;
import com.zpi.entity.Danie;
import com.zpi.entity.Przepis;
import com.zpi.entity.Typ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dima on 3/30/17.
 */
@Service
public class DanieAssemblerImpl implements DanieAssembler{

    @Autowired
    private DanieDts danieDts;

    @Override
    public DanieDts toDanieAssembler(DanieDto danie, TypDto typ, PrzepisDto przepis) {
        this.danieDts.setIdDanie(danie.getIdDanie());
        this.danieDts.setOpisDanie(danie.getOpisDanie());
        this.danieDts.setZdjecieDanie(danie.getZdjecieDanie());
        this.danieDts.setNazwaDanie(danie.getNazwaDanie());
        this.danieDts.setNazwaTyp(typ.getNazwaTyp());
        this.danieDts.setCzasPrzepis(przepis.getCzasPrzepis());
        this.danieDts.setOpisPrzepis(przepis.getOpisPrzepis());

        return danieDts;
    }
}
