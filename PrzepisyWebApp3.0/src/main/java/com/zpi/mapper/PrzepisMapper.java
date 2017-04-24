package com.zpi.mapper;

import com.zpi.dto.PrzepisDto;
import com.zpi.entity.Przepis;

/**
 * Created by dima on 3/30/17.
 */
public interface PrzepisMapper {

    PrzepisDto toPrzepisDto(Przepis przepis);
}
