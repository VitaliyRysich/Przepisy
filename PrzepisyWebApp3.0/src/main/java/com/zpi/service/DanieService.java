package com.zpi.service;

import com.zpi.entity.Danie;

import java.util.List;

/**
 * Created by dima on 3/21/17.
 */
public interface DanieService {
    List<Danie> getAllDanie();
    Danie getDanieById(long id);
    Danie getDanieById2(long id);
    List<Danie> getDanieByName(String name);

}
