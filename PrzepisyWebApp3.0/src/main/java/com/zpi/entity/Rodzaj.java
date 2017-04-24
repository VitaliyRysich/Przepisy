package com.zpi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Entity
@Table(name = "rodzaj")
public class Rodzaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rodzaj")
    private long idRodzaj;

    @Column(name = "nazwa_rodzaj")
    @NotNull
    private String nazwaRodzaj;

    public long getIdRodzaj() {
        return idRodzaj;
    }

    public void setIdRodzaj(long idRodzaj) {
        this.idRodzaj = idRodzaj;
    }

    public String getNazwaRodzaj() {
        return nazwaRodzaj;
    }

    public void setNazwaRodzaj(String nazwaRodzaj) {
        this.nazwaRodzaj = nazwaRodzaj;
    }
}
