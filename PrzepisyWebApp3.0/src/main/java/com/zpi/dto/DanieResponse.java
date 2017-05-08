package com.zpi.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by dima on 07/05/17.
 */
@Component
@Scope(value = "prototype")
public class DanieResponse {

    private long IdDanie;

    private String NazwaDanie;

    private String OpisDanie;

    private String ZdjecieDanie;

    private long IdTyp;

    private long IdPrzepis;


    public DanieResponse() {}

    public DanieResponse(long idDanie, String nazwaDanie, String opisDanie, String zdjecieDanie, long idTyp, long idPrzepis) {
        IdDanie = idDanie;
        NazwaDanie = nazwaDanie;
        OpisDanie = opisDanie;
        ZdjecieDanie = zdjecieDanie;
        IdTyp = idTyp;
        IdPrzepis = idPrzepis;
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

    public long getIdTyp() {
        return IdTyp;
    }

    public void setIdTyp(long idTyp) {
        IdTyp = idTyp;
    }

    public long getIdPrzepis() {
        return IdPrzepis;
    }

    public void setIdPrzepis(long idPrzepis) {
        IdPrzepis = idPrzepis;
    }
}
