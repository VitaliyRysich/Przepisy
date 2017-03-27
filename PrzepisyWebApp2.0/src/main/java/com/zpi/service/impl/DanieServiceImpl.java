package com.zpi.service.impl;

import com.zpi.dao.DanieDao;
import com.zpi.entity.Danie;
import com.zpi.service.DanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dima on 3/21/17.
 */
@Service
public class DanieServiceImpl implements DanieService{

    @Autowired
    private DanieDao danieDao;


    @Override
    public List<Danie> getAllDanie() {
        return danieDao.getAllDanie();
    }

    @Override
    public Danie getDanieById(long id) {
        return danieDao.getDanieById(id);
    }

    @Override
    public List<Danie> getDanieByName(String name){
        return danieDao.getDanieByName(name);
    }

}
