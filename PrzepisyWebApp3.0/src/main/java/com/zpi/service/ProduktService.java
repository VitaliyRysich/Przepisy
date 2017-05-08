package com.zpi.service;

import com.zpi.entity.Produkt;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ProduktService {
    Produkt getProduktById(long id);
    List<Produkt> getProduktsByRodzaj(long id);
}
