package com.zpi.mapper;

import com.zpi.dto.DanieDto;
import com.zpi.entity.Danie;

import java.util.List;

/**
 * Created by dima on 3/30/17.
 */
public interface DanieMapper {

    DanieDto toDanieDto(Danie danie);
    List<DanieDto> toDanieDtoList(List<Danie> ListDanie);
}
