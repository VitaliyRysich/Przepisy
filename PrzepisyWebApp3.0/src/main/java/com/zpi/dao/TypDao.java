package com.zpi.dao;

import com.zpi.entity.Danie;
import com.zpi.entity.Typ;

import java.util.List;

/**
 * Created by Vitalii on 27.03.2017.
 */
public interface TypDao {

    List<Typ> getAllTyp();
    Typ getTypById(long id);
    List<Typ> getIdByNazwa(String nazwa);
 }
