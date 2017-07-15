package com.kubacki.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KUBACM on 2017-07-15.
 */
public class NotatkiEntityPK implements Serializable {
    private int idnotatki;
    private int zajeciaIdzajecia;

    @Column(name = "idnotatki")
    @Id
    public int getIdnotatki() {
        return idnotatki;
    }

    public void setIdnotatki(int idnotatki) {
        this.idnotatki = idnotatki;
    }

    @Column(name = "zajecia_idzajecia")
    @Id
    public int getZajeciaIdzajecia() {
        return zajeciaIdzajecia;
    }

    public void setZajeciaIdzajecia(int zajeciaIdzajecia) {
        this.zajeciaIdzajecia = zajeciaIdzajecia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotatkiEntityPK that = (NotatkiEntityPK) o;

        if (idnotatki != that.idnotatki) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idnotatki;
        result = 31 * result + zajeciaIdzajecia;
        return result;
    }
}
