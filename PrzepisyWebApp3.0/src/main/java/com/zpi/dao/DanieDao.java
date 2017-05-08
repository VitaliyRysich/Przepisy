package com.zpi.dao;

import com.zpi.entity.Danie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima on 3/20/17.
 */

public interface DanieDao {

    List<Danie> getAllDanie();
    Danie getDanieById(long id);
    Danie getDanieById2(long id);
    List<Danie> getDanieByName(String name);
    List<Danie> getDanieByTyp(String typ);

}
