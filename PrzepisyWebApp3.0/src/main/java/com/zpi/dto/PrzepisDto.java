package com.zpi.dto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by dima on 3/30/17.
 */
@Component
public class PrzepisDto {

    private long idPrzepis;

    private String opisPrzepis;

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
