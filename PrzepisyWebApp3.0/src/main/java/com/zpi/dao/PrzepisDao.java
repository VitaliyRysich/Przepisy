package com.zpi.dao;

import com.zpi.entity.Przepis;
import com.zpi.entity.Typ;

/**
 * Created by dima on 3/30/17.
 */
public interface PrzepisDao {

    Przepis getPrzepisById(long id);
}
