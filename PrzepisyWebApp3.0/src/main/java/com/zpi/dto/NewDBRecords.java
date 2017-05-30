package com.zpi.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 22.05.2017.
 */
public class NewDBRecords {


    private long nazwaTyp;  // It's IdTyp
    private String opisPrzepis;
    private long czasPrzepis;

    private String nazwaDanie;
    private String OpisDanie;
    private String ZdjecieDanie;
    List<ProduktNazwaIlosc> produkty = new ArrayList<>();


    public NewDBRecords(){}
    public NewDBRecords(String nazwaDanie,
                        String opisDanie,
                        String zdjecieDanie,
                        List<ProduktNazwaIlosc> produkty,
                        String opisPrzepis,
                        long czasPrzepis,
                        long nazwaTyp
                        ) {
        this.nazwaDanie = nazwaDanie;
        OpisDanie = opisDanie;
        ZdjecieDanie = zdjecieDanie;
        this.produkty = produkty;
        this.opisPrzepis = opisPrzepis;
        this.czasPrzepis = czasPrzepis;
        this.nazwaTyp = nazwaTyp;
    }

    public long getNazwaTyp() {
        return nazwaTyp;
    }

    public void setNazwaTyp(long nazwaTyp) {
        this.nazwaTyp = nazwaTyp;
    }

    public String getNazwaDanie() {
        return nazwaDanie;
    }

    public void setNazwaDanie(String nazwaDanie) {
        this.nazwaDanie = nazwaDanie;
    }

    public String getOpisDanie() {
        return OpisDanie;
    }

    public void setOpisDanie(String opisDanie) {
        OpisDanie = opisDanie;
    }

    public String getZdjecieDanie() {
        return ZdjecieDanie;
    }

    public void setZdjecieDanie(String zdjecieDanie) {
        ZdjecieDanie = zdjecieDanie;
    }

    public List<ProduktNazwaIlosc> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<ProduktNazwaIlosc> produkty) {
        this.produkty = produkty;
    }

    public String getOpisPrzepis() {
        return opisPrzepis;
    }

    public void setOpisPrzepis(String opisPrzepis) {
        this.opisPrzepis = opisPrzepis;
    }

    public long getCzasPrzepis() {
        return czasPrzepis;
    }

    public void setCzasPrzepis(long czasPrzepis) {
        this.czasPrzepis = czasPrzepis;
    }




}
