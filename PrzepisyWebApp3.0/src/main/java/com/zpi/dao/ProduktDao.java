package com.zpi.dao;

import com.zpi.entity.Produkt;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ProduktDao {
    Produkt getProduktById(long id);
    Produkt getProduktByName(String name);
    List<Produkt> getProduktsByRodzaj(long id);
 }
