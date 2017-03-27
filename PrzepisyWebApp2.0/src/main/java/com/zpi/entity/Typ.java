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
    private long id_typ;

    @Column(name = "nazwa_typ")
    @NotNull
    private String nazwa_typ;


    public Typ(){}
    public Typ(String nazwa_typ){
        this.nazwa_typ=nazwa_typ;
    }

    public long getId_typ() {
        return id_typ;
    }

    public void setId_typ(long id_typ) {
        this.id_typ = id_typ;
    }

    public String getNazwa_typ() {
        return nazwa_typ;
    }

    public void setNazwa_typ(String nazwa_typ) {
        this.nazwa_typ = nazwa_typ;
    }
}


