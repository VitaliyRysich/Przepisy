package com.zpi.dao;

import com.zpi.entity.Zawiera;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ZawieraDao {
    List<Zawiera> getAllZawiera();
    List<Zawiera> getAllZawieraByIdDanie(long id);
    long getRezult(long idDanie, long idProdukt);
    long getSumProd(long idDanie);
}
