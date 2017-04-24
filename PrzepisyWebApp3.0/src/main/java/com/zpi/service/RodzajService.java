package com.zpi.service;

import com.zpi.entity.Rodzaj;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vitalii on 28.03.2017.
 */

public interface RodzajService {

    List<Rodzaj> getAllRodzaj();
}
