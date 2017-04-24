package com.zpi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vitalii on 27.03.2017.
 */

@Entity
@Table(name = "typ")
public class Typ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_typ")
    private long idTyp;

    @Column(name = "nazwa_typ")
    @NotNull
    private String nazwaTyp;


    public Typ(){}
    public Typ(String nazwaTyp){
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


