package com.zpi.dts;

import com.zpi.dto.ProduktDtoAdv;
import com.zpi.entity.Danie;
import com.zpi.entity.Produkt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dima on 07/05/17.
 */
public class AdvDanieDts implements Comparable<AdvDanieDts>{

    private long IdDanie;

    private String NazwaDanie;

    private String OpisDanie;

    private String ZdjecieDanie;

    private long czasPrzepis;

    private List<ProduktDtoAdv> isIn = new ArrayList<>();
    private List<ProduktDtoAdv> isNotIn = new ArrayList<>();

    private double ocena;

    private double sumaDoplaty;

    private String nazwaTyp;

    private String opisPrzepis;

    public AdvDanieDts(Danie danie) {
        this.IdDanie = danie.getIdDanie();
        this.NazwaDanie = danie.getNazwaDanie();
        this.OpisDanie = danie.getOpisDanie();
        this.ZdjecieDanie = danie.getZdjecieDanie();

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

    public long getCzasPrzepis() {
        return czasPrzepis;
    }

    public void setCzasPrzepis(long czasPrzepis) {
        this.czasPrzepis = czasPrzepis;
    }

    public List<ProduktDtoAdv> getIsIn() {
        return isIn;
    }

    public void setIsIn(List<ProduktDtoAdv> isIn) {
        this.isIn = isIn;
    }

    public List<ProduktDtoAdv> getIsNotIn() {
        return isNotIn;
    }

    public void setIsNotIn(List<ProduktDtoAdv> isNotIn) {
        this.isNotIn = isNotIn;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public double getSumaDoplaty() {
        return sumaDoplaty;
    }

    public void setSumaDoplaty(double sumaDoplaty) {
        this.sumaDoplaty = sumaDoplaty;
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

    @Override
    public int compareTo(AdvDanieDts o) {
        return (int)(this.ocena*100-o.getOcena()*100);
    }

    public static Comparator<AdvDanieDts> ocenaComparator = new Comparator<AdvDanieDts>(){

        @Override
        public int compare(AdvDanieDts o1, AdvDanieDts o2) {
            return (int)(o2.getOcena()*100-o1.getOcena()*100);
        }
    };
}
