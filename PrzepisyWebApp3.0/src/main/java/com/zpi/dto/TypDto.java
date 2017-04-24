package com.zpi.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by dima on 3/30/17.
 */
@Component
public class TypDto {

    private long idTyp;

    private String nazwaTyp;


    public TypDto(){}
    public TypDto(String nazwaTyp){
        this.nazwaTyp=nazwaTyp;
    }

    public long getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(long idTyp) {
        this.idTyp = idTyp;
    }

    public String getNazwaTyp() {
        return nazwaTyp;
    }

    public void setNazwaTyp(String nazwaTyp) {
        this.nazwaTyp = nazwaTyp;
    }
}
