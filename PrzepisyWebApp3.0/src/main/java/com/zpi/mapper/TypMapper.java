package com.zpi.mapper;

import com.zpi.dao.TypDao;
import com.zpi.dto.TypDto;
import com.zpi.entity.Typ;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dima on 3/30/17.
 */

public interface TypMapper {
    TypDto toTypDto (Typ typ);
    List<TypDto> toTypDtoList(List<Typ> typList);
}
