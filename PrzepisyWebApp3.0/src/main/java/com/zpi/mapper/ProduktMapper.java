package com.zpi.mapper;

import com.zpi.dto.DanieDto;
import com.zpi.dto.ProduktDto;
import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ProduktMapper {
    ProduktDto toProduktDto(Produkt produkt);
}
