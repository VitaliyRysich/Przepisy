package com.zpi.service.impl;

import com.zpi.dao.ObjectInsertDao;
import com.zpi.dao.PrzepisDao;
import com.zpi.dto.NewDBRecords;
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
    @Autowired
    private ObjectInsertDao objectInsertDao;

    @Override
    public Przepis getPrzepisById(long id) {
        return przepisDao.getPrzepisById(id);
    }

    @Override
    public void insertPrzepis(NewDBRecords newDBRecords) {
        objectInsertDao.insertObject(newDBRecords);
    }
}
