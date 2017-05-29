package com.zpi.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 22.05.2017.
 */
public class NewDBRecords {
    private String nazwaDanie;
    private String OpisDanie;
    private String ZdjecieDanie;
    private long idTyp;

    List<ProduktNazwaIlosc> produktNazwaIloscList = new ArrayList<>();

    private String opisPrzepis;
    private long czasPrzepis;

    public NewDBRecords(){}
    public NewDBRecords(String nazwaDanie,
                        String opisDanie,
                        String zdjecieDanie,
                        List<ProduktNazwaIlosc> produktNazwaIloscList,
                        String opisPrzepis,
                        long czasPrzepis,
                        long idTyp
                        ) {
        this.nazwaDanie = nazwaDanie;
        OpisDanie = opisDanie;
        ZdjecieDanie = zdjecieDanie;
        this.produktNazwaIloscList = produktNazwaIloscList;
        this.opisPrzepis = opisPrzepis;
        this.czasPrzepis = czasPrzepis;
        this.idTyp = idTyp;
    }

    public long getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(long idTyp) {
        this.idTyp = idTyp;
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

    public List<ProduktNazwaIlosc> getProduktNazwaIloscList() {
        return produktNazwaIloscList;
    }

    public void setProduktNazwaIloscList(List<ProduktNazwaIlosc> produktNazwaIloscList) {
        this.produktNazwaIloscList = produktNazwaIloscList;
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
