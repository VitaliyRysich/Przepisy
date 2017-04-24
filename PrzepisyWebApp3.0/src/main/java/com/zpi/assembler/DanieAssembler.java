package com.zpi.assembler;

import com.zpi.dto.DanieDto;
import com.zpi.dto.PrzepisDto;
import com.zpi.dto.TypDto;
import com.zpi.dts.DanieDts;
import com.zpi.entity.Danie;
import com.zpi.entity.Przepis;
import com.zpi.entity.Typ;

/**
 * Created by dima on 3/30/17.
 */
public interface DanieAssembler {

    DanieDts toDanieAssembler (DanieDto danie, TypDto typ, PrzepisDto przepis);
}
