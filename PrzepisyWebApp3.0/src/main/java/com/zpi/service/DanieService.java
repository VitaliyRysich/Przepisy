package com.zpi.service;

import com.zpi.dto.ReqOb;
import com.zpi.dts.AdvDanieDts;
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
    List<Danie> getDanieByTyp(String typ);

    List<AdvDanieDts> getSortDanie (ReqOb reqOb);

}
