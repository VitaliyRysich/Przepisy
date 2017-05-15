package com.zpi.dto;

import org.springframework.stereotype.Component;

/**
 * Created by dima on 13/05/17.
 */
@Component
public class ProduktDtoAdv {
    private long idProdukt;
    private String nazwaProdukt;
    private double cenaProdukt;
    private long idRodzaj;
    private String ilosc;

    public ProduktDtoAdv(){}

    public ProduktDtoAdv(long idProdukt, String nazwaProdukt, double cenaProdukt, long idRodzaj, String ilosc) {
        this.idProdukt = idProdukt;
        this.nazwaProdukt = nazwaProdukt;
        this.cenaProdukt = cenaProdukt;
        this.idRodzaj = idRodzaj;
        this.ilosc = ilosc;
    }

    public long getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(long idProdukt) {
        this.idProdukt = idProdukt;
    }

    public String getNazwaProdukt() {
        return nazwaProdukt;
    }

    public void setNazwaProdukt(String nazwaProdukt) {
        this.nazwaProdukt = nazwaProdukt;
    }

    public double getCenaProdukt() {
        return cenaProdukt;
    }

    public void setCenaProdukt(double cenaProdukt) {
        this.cenaProdukt = cenaProdukt;
    }

    public long getIdRodzaj() {
        return idRodzaj;
    }


    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }



    public void setIdRodzaj(long idRodzaj) {
        this.idRodzaj = idRodzaj;
    }
}
