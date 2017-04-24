package com.zpi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Entity
@Table(name = "przepis")
public class Przepis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_przepis")
    private long idPrzepis;

    @Column(name = "opis_przepis")
    @NotNull
    private String opisPrzepis;

    @Column(name = "czas_przepis")
    @NotNull
    private long czasPrzepis;

    public long getIdPrzepis() {
        return idPrzepis;
    }

    public void setIdPrzepis(long idPrzepis) {
        this.idPrzepis = idPrzepis;
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
