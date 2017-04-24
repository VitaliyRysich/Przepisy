package com.zpi.mapper.impl;

import com.zpi.dto.ProduktDto;
import com.zpi.entity.Produkt;
import com.zpi.mapper.ProduktMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Service
public class ProduktMapperImpl implements ProduktMapper {
    @Autowired
    ProduktDto produktDto;

    @Override
    public ProduktDto toProduktDto(Produkt produkt) {
        this.produktDto.setCenaProdukt(produkt.getCenaProdukt());
        this.produktDto.setIdProdukt(produkt.getIdProdukt());
        this.produktDto.setIdRodzaj(produkt.getIdRodzaj());
        this.produktDto.setNazwaProdukt(produkt.getNazwaProdukt());
        return this.produktDto;
    }
}
