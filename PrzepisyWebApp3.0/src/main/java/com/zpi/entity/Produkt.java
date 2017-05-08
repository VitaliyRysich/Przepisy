package com.zpi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Entity
@Table(name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produkt")
    private long idProdukt;
    @Column(name = "nazwa_produkt")
    @NotNull
    private String nazwaProdukt;
    @Column(name = "cena_produkt")
    @NotNull
    private double cenaProdukt;
    @Column(name = "id_rodzaj")
    private long idRodzaj;

/*
    @ManyToMany
    private List<Danie> danieList;
*/

    public long getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(long idProdukt) {
        this.idProdukt = idProdukt;
    }

    public String getNazwaProdukt() {
        return nazwaProdukt;
    }

    public void setNazwaProdukt(String nazwaProdukt) {
        this.nazwaProdukt = nazwaProdukt;
    }

    public double getCenaProdukt() {
        return cenaProdukt;
    }

    public void setCenaProdukt(double cenaProdukt) {
        this.cenaProdukt = cenaProdukt;
    }

    public long getIdRodzaj() {
        return idRodzaj;
    }

    public void setIdRodzaj(long idRodzaj) {
        this.idRodzaj = idRodzaj;
    }

/*    public List<Danie> getDanieList() {
        return danieList;
    }

    public void setDanieList(List<Danie> danieList) {
        this.danieList = danieList;
    }*/

    @Override
    public String toString() {
        return
                " nazwaProdukt " + nazwaProdukt ;
    }
}
