package com.kubacki.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KUBACM on 2017-07-15.
 */
public class ZajeciaEntityPK implements Serializable {
    private int idzajecia;
    private int przedmiotIdprzedmiot;
    private int typZajecIdtypZajec;
    private int salaIdsala;
    private int wykladowcyIdwykladowcy;

    @Column(name = "idzajecia")
    @Id
    public int getIdzajecia() {
        return idzajecia;
    }

    public void setIdzajecia(int idzajecia) {
        this.idzajecia = idzajecia;
    }

    @Column(name = "przedmiot_idprzedmiot")
    @Id
    public int getPrzedmiotIdprzedmiot() {
        return przedmiotIdprzedmiot;
    }

    public void setPrzedmiotIdprzedmiot(int przedmiotIdprzedmiot) {
        this.przedmiotIdprzedmiot = przedmiotIdprzedmiot;
    }

    @Column(name = "typ_zajec_idtyp_zajec")
    @Id
    public int getTypZajecIdtypZajec() {
        return typZajecIdtypZajec;
    }

    public void setTypZajecIdtypZajec(int typZajecIdtypZajec) {
        this.typZajecIdtypZajec = typZajecIdtypZajec;
    }

    @Column(name = "sala_idsala")
    @Id
    public int getSalaIdsala() {
        return salaIdsala;
    }

    public void setSalaIdsala(int salaIdsala) {
        this.salaIdsala = salaIdsala;
    }

    @Column(name = "wykladowcy_idwykladowcy")
    @Id
    public int getWykladowcyIdwykladowcy() {
        return wykladowcyIdwykladowcy;
    }

    public void setWykladowcyIdwykladowcy(int wykladowcyIdwykladowcy) {
        this.wykladowcyIdwykladowcy = wykladowcyIdwykladowcy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZajeciaEntityPK that = (ZajeciaEntityPK) o;

        if (idzajecia != that.idzajecia) return false;
        if (przedmiotIdprzedmiot != that.przedmiotIdprzedmiot) return false;
        if (typZajecIdtypZajec != that.typZajecIdtypZajec) return false;
        if (salaIdsala != that.salaIdsala) return false;
        if (wykladowcyIdwykladowcy != that.wykladowcyIdwykladowcy) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idzajecia;
        result = 31 * result + przedmiotIdprzedmiot;
        result = 31 * result + typZajecIdtypZajec;
        result = 31 * result + salaIdsala;
        result = 31 * result + wykladowcyIdwykladowcy;
        return result;
    }
}
