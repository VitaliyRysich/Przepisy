package com.zpi.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by dima on 3/20/17.
 */
@Entity
@Table(name = "danie")
public class Danie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdDanie")
    private long IdDanie;

    @Column(name = "NazwaDanie")
    @NotNull
    private String NazwaDanie;

    @Column(name = "OpisDanie")
    @NotNull
    private String OpisDanie;

    @Column(name = "IdTyp")
    @NotNull
    private long IdTyp;

    @Column(name = "IdPrzepis")
    @NotNull
    private long IdPrzepis;

    public Danie() {}

    public Danie(String NazwaDanie, String OpisDanie, long IdTyp, long IdPrzepis) {
        this.NazwaDanie = NazwaDanie;
        this.OpisDanie = OpisDanie;
        this.IdTyp = IdTyp;
        this.IdPrzepis = IdPrzepis;
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
}
