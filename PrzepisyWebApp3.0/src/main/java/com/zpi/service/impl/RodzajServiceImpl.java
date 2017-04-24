package com.zpi.service.impl;

import com.zpi.dao.RodzajDao;
import com.zpi.entity.Rodzaj;
import com.zpi.service.RodzajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Service
public class RodzajServiceImpl implements RodzajService {

    @Autowired
    RodzajDao rodzajDao;

    @Override
    public List<Rodzaj> getAllRodzaj() {
        return rodzajDao.getAllRodzaj();
    }
}
