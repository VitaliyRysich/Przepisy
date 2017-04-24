package com.zpi.service.impl;

import com.zpi.dao.PrzepisDao;
import com.zpi.entity.Przepis;
import com.zpi.service.PrzepisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dima on 3/30/17.
 */
@Service
public class PrzepisServiceImpl implements PrzepisService {

    @Autowired
    private PrzepisDao przepisDao;

    @Override
    public Przepis getPrzepisById(long id) {
        return przepisDao.getPrzepisById(id);
    }
}
