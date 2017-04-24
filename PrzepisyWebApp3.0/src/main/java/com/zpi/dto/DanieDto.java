package com.zpi.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by Vitalii on 29.03.2017.
 */
@Component
@Scope(value = "prototype")
public class DanieDto {

        private long IdDanie;

        private String NazwaDanie;

        private String OpisDanie;

        private String ZdjecieDanie;

        private long IdTyp;
    
        private long IdPrzepis;

        public DanieDto() {}

        public DanieDto(long idDanie, String nazwaDanie, String opisDanie, String zdjecieDanie, long idTyp, long idPrzepis) {
            IdDanie = idDanie;
            NazwaDanie = nazwaDanie;
            ZdjecieDanie=zdjecieDanie;
            OpisDanie = opisDanie;
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

    public String getZdjecieDanie() {
        return ZdjecieDanie;
    }

    public void setZdjecieDanie(String zdjecieDanie) {
        ZdjecieDanie = zdjecieDanie;
    }
}
