package com.kubacki.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KUBACM on 2017-07-15.
 */
public class PracaDomowaEntityPK implements Serializable {
    private int idpracaDomowa;
    private int zajeciaIdzajecia;

    @Column(name = "idpraca_domowa")
    @Id
    public int getIdpracaDomowa() {
        return idpracaDomowa;
    }

    public void setIdpracaDomowa(int idpracaDomowa) {
        this.idpracaDomowa = idpracaDomowa;
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

        PracaDomowaEntityPK that = (PracaDomowaEntityPK) o;

        if (idpracaDomowa != that.idpracaDomowa) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpracaDomowa;
        result = 31 * result + zajeciaIdzajecia;
        return result;
    }
}
