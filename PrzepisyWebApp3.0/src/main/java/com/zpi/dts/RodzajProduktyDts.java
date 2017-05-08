package com.zpi.dts;

import com.zpi.entity.Produkt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 08.05.2017.
 */
public class RodzajProduktyDts {

    private String nazwaRodzaj;
    private List<String> produktList = new ArrayList<>();

    public String getNazwaRodzaj() {
        return nazwaRodzaj;
    }

    public void setNazwaRodzaj(String nazwaRodzaj) {
        this.nazwaRodzaj = nazwaRodzaj;
    }

    public List<String> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<String> produktList) {
        this.produktList = produktList;
    }


}
