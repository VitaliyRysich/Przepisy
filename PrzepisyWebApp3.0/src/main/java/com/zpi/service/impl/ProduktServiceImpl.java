package com.zpi.service.impl;

import com.zpi.dao.ProduktDao;
import com.zpi.entity.Produkt;
import com.zpi.service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Service
public class ProduktServiceImpl implements ProduktService {
    @Autowired
    ProduktDao produktDao;
    @Override
    public Produkt getProduktById(long id) {
        return produktDao.getProduktById(id);
    }
}
