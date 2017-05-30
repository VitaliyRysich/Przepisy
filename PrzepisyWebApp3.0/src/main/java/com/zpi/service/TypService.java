package com.zpi.service;

import com.zpi.entity.Danie;
import com.zpi.entity.Typ;

import java.util.List;

/**
 * Created by Vitalii on 27.03.2017.
 */
public interface TypService {

    List<Typ> getAllTyp();
    Typ getTypById(long id);
    List<Typ> getTypByNazwa(String nazwa);
    Long getIdByNazwa(String nazwa);
}
