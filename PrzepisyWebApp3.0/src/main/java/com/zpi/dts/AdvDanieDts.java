package com.zpi.dts;

import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 07/05/17.
 */
public class AdvDanieDts {

    private long IdDanie;

    private String NazwaDanie;

    private String OpisDanie;

    private String ZdjecieDanie;

    /*private String nazwaTyp;

    private String opisPrzepis;

    private long czasPrzepis;*/


    private List<Produkt> isIn = new ArrayList<>();
    private List<Produkt> isNotIn = new ArrayList<>();

    private double ocena;

    private double sumaDoplaty;
    public AdvDanieDts(Danie danie) {
        this.IdDanie = danie.getIdDanie();
        this.NazwaDanie = danie.getNazwaDanie();
        this.OpisDanie = danie.getOpisDanie();
        this.ZdjecieDanie = danie.getZdjecieDanie();

    }
    public void addIsIn(Produkt produkt) {
        isIn.add(produkt);
    }

    public void addIsNotIn(Produkt produkt) {
        isNotIn.add(produkt);
    }

    public List<Produkt> getIsIn() {
        return isIn;
    }

    public void setIsIn(List<Produkt> isIn) {
        this.isIn = isIn;
    }

    public List<Produkt> getIsNotIn() {
        return isNotIn;
    }

    public void setIsNotIn(List<Produkt> isNotIn) {
        this.isNotIn = isNotIn;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

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

    public String getZdjecieDanie() {
        return ZdjecieDanie;
    }

    public void setZdjecieDanie(String zdjecieDanie) {
        ZdjecieDanie = zdjecieDanie;
    }

    public double getSumaDoplaty() {
        return sumaDoplaty;
    }

    public void setSumaDoplaty(double sumaDoplaty) {
        this.sumaDoplaty = sumaDoplaty;
    }
}
