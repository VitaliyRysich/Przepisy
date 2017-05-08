package com.zpi.dto;

/**
 * Created by dima on 06/05/17.
 */
public class ReqOb
{
    String nazwaTyp;
    int cena;
    String [] produkty;

    public ReqOb() {

    }

    public ReqOb(String nazwaTyp, int cena, String[] produkty) {
        this.nazwaTyp = nazwaTyp;
        this.cena = cena;
        this.produkty = produkty;
    }

    public String getNazwaTyp() {
        return nazwaTyp;
    }

    public void setNazwaTyp(String nazwaTyp) {
        this.nazwaTyp = nazwaTyp;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String[] getProdukty() {
        return produkty;
    }

    public void setProdukty(String[] produkty) {
        this.produkty = produkty;
    }
}
