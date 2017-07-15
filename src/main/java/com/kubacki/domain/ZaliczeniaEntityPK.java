package com.kubacki.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KUBACM on 2017-07-15.
 */
public class ZaliczeniaEntityPK implements Serializable {
    private int idzaliczenia;
    private int zajeciaIdzajecia;
    private int typZaliczeniaIdtypZaliczenia;
    private int salaIdsala;

    @Column(name = "idzaliczenia")
    @Id
    public int getIdzaliczenia() {
        return idzaliczenia;
    }

    public void setIdzaliczenia(int idzaliczenia) {
        this.idzaliczenia = idzaliczenia;
    }

    @Column(name = "zajecia_idzajecia")
    @Id
    public int getZajeciaIdzajecia() {
        return zajeciaIdzajecia;
    }

    public void setZajeciaIdzajecia(int zajeciaIdzajecia) {
        this.zajeciaIdzajecia = zajeciaIdzajecia;
    }

    @Column(name = "typ_zaliczenia_idtyp_zaliczenia")
    @Id
    public int getTypZaliczeniaIdtypZaliczenia() {
        return typZaliczeniaIdtypZaliczenia;
    }

    public void setTypZaliczeniaIdtypZaliczenia(int typZaliczeniaIdtypZaliczenia) {
        this.typZaliczeniaIdtypZaliczenia = typZaliczeniaIdtypZaliczenia;
    }

    @Column(name = "sala_idsala")
    @Id
    public int getSalaIdsala() {
        return salaIdsala;
    }

    public void setSalaIdsala(int salaIdsala) {
        this.salaIdsala = salaIdsala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZaliczeniaEntityPK that = (ZaliczeniaEntityPK) o;

        if (idzaliczenia != that.idzaliczenia) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;
        if (typZaliczeniaIdtypZaliczenia != that.typZaliczeniaIdtypZaliczenia) return false;
        if (salaIdsala != that.salaIdsala) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idzaliczenia;
        result = 31 * result + zajeciaIdzajecia;
        result = 31 * result + typZaliczeniaIdtypZaliczenia;
        result = 31 * result + salaIdsala;
        return result;
    }
}
