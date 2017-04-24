package com.zpi.service.impl;

import com.zpi.dao.ZawieraDao;
import com.zpi.entity.Zawiera;
import com.zpi.service.ZawieraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Service
public class ZawieraServiceImpl implements ZawieraService{
    @Autowired
    ZawieraDao zawieraDao;

    @Override
    public List<Zawiera> getAllZawiera() {
        return zawieraDao.getAllZawiera();
    }

    @Override
    public List<Zawiera> getAllZawieraByIdDanie(long id) {
        return zawieraDao.getAllZawieraByIdDanie(id);
    }
}
