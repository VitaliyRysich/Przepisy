package com.zpi.dao;

import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ProduktDao {
    Produkt getProduktById(long id);
}
