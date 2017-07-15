package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "notatki", schema = "mydb", catalog = "")
@IdClass(NotatkiEntityPK.class)
public class NotatkiEntity {
    private int idnotatki;
    private int zajeciaIdzajecia;
    private String tresc;

    @Id
    @Column(name = "idnotatki")
    public int getIdnotatki() {
        return idnotatki;
    }

    public void setIdnotatki(int idnotatki) {
        this.idnotatki = idnotatki;
    }

    @Id
    @Column(name = "zajecia_idzajecia")
    public int getZajeciaIdzajecia() {
        return zajeciaIdzajecia;
    }

    public void setZajeciaIdzajecia(int zajeciaIdzajecia) {
        this.zajeciaIdzajecia = zajeciaIdzajecia;
    }

    @Basic
    @Column(name = "tresc")
    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotatkiEntity that = (NotatkiEntity) o;

        if (idnotatki != that.idnotatki) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;
        if (tresc != null ? !tresc.equals(that.tresc) : that.tresc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idnotatki;
        result = 31 * result + zajeciaIdzajecia;
        result = 31 * result + (tresc != null ? tresc.hashCode() : 0);
        return result;
    }
}
