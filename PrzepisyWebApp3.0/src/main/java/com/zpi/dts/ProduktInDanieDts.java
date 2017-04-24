package com.zpi.dts;

import org.springframework.stereotype.Component;

/**
 * Created by Vitalii on 31.03.2017.
 */
@Component
public class ProduktInDanieDts {
    private long idProdukt;
    private String nazwaProdukt;
    private String ilosc;
    private double wartosc;

    public ProduktInDanieDts() {

    }

    public ProduktInDanieDts(long idProdukt, String nazwaProdukt, String ilosc, double wartosc) {
        this.idProdukt = idProdukt;
        this.nazwaProdukt = nazwaProdukt;
        this.ilosc = ilosc;
        this.wartosc = wartosc;
    }

    public String getNazwaProdukt() {
        return nazwaProdukt;
    }

    public long getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(long idProdukt) {
        this.idProdukt = idProdukt;
    }

    public void setNazwaProdukt(String nazwaProdukt) {
        this.nazwaProdukt = nazwaProdukt;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {

        this.ilosc = ilosc;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }
}
