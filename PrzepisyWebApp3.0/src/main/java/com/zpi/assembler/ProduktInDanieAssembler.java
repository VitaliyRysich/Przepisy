package com.zpi.assembler;

import com.zpi.dts.ProduktInDanieDts;
import com.zpi.entity.Zawiera;

import java.util.List;

/**
 * Created by Vitalii on 31.03.2017.
 */
public interface ProduktInDanieAssembler {
    List<ProduktInDanieDts> toProduktInDanieDtsList(List<Zawiera> zawieraList);
}
