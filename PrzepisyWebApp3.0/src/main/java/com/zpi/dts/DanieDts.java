package com.zpi.dts;

import org.springframework.stereotype.Component;

/**
 * Created by dima on 3/30/17.
 */
@Component
public class DanieDts {

    private long IdDanie;

    private String NazwaDanie;

    private String OpisDanie;

    private String ZdjecieDanie;

    private String nazwaTyp;

    private String opisPrzepis;

    private long czasPrzepis;


    public long getIdDanie() {
        return IdDanie;
    }

    public void setIdDanie(long idDanie) {
        IdDanie = idDanie;
    }

    public String getNazwaDanie() {
        return NazwaDanie;
    }

    public void setNazwaDanie(String nazwaDanie) {
        NazwaDanie = nazwaDanie;
    }

    public String getOpisDanie() {
        return OpisDanie;
    }

    public void setOpisDanie(String opisDanie) {
        OpisDanie = opisDanie;
    }

    public String getNazwaTyp() {
        return nazwaTyp;
    }

    public void setNazwaTyp(String nazwaTyp) {
        this.nazwaTyp = nazwaTyp;
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

    public String getZdjecieDanie() {
        return ZdjecieDanie;
    }

    public void setZdjecieDanie(String zdjecieDanie) {
        ZdjecieDanie = zdjecieDanie;
    }
}
