package com.zpi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Vitalii on 28.03.2017.
 */
@Entity
@Table(name = "zawiera")
@IdClass(ZawieraPK.class)
public class Zawiera {
    @Id
    @Column(name = "id_danie")
    @NotNull
    private long idDanie;
    @Id
    @Column(name = "id_produkt")
    @NotNull
    private long idProdukt;

    @Column(name = "ilosc")
    private String ilosc;

    public long getIdDanie() {
        return idDanie;
    }

    public void setIdDanie(long idDanie) {
        this.idDanie = idDanie;
    }

    public long getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(long idProdukt) {
        this.idProdukt = idProdukt;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }
}
