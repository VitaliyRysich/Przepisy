package com.zpi.service;

import com.zpi.entity.Danie;
import com.zpi.entity.Zawiera;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ZawieraService {
    List<Zawiera> getAllZawiera();
    List<Zawiera> getAllZawieraByIdDanie(long id);
}
