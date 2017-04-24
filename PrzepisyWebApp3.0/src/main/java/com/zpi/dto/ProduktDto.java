package com.zpi.dto;

import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Component
public class ProduktDto {
    private long idProdukt;
    private String nazwaProdukt;
    private double cenaProdukt;
    private long idRodzaj;

    ProduktDto(){}

    public ProduktDto(long idProdukt, String nazwaProdukt, double cenaProdukt, long idRodzaj) {
        this.idProdukt = idProdukt;
        this.nazwaProdukt = nazwaProdukt;
        this.cenaProdukt = cenaProdukt;
        this.idRodzaj = idRodzaj;
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

    public void setIdRodzaj(long idRodzaj) {
        this.idRodzaj = idRodzaj;
    }
}
