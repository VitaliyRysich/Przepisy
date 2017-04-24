package com.zpi.entity;

import java.io.Serializable;

/**
 * Created by Vitalii on 31.03.2017.
 */
public class ZawieraPK implements Serializable {
    protected long idDanie;
    protected long idProdukt;

    public ZawieraPK(){}
    public ZawieraPK(long idDanie, long idProdukt){
        this.idDanie=idDanie;
        this.idProdukt=idProdukt;
    }
}
