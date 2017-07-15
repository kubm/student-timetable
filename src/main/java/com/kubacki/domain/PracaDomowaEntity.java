package com.kubacki.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "praca_domowa", schema = "mydb", catalog = "")
@IdClass(PracaDomowaEntityPK.class)
public class PracaDomowaEntity {
    private int idpracaDomowa;
    private int zajeciaIdzajecia;
    private String tytul;
    private String tresc;
    private Timestamp dzien;
    private Integer ocena;

    @Id
    @Column(name = "idpraca_domowa")
    public int getIdpracaDomowa() {
        return idpracaDomowa;
    }

    public void setIdpracaDomowa(int idpracaDomowa) {
        this.idpracaDomowa = idpracaDomowa;
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
    @Column(name = "tytul")
    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Basic
    @Column(name = "tresc")
    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Basic
    @Column(name = "dzien")
    public Timestamp getDzien() {
        return dzien;
    }

    public void setDzien(Timestamp dzien) {
        this.dzien = dzien;
    }

    @Basic
    @Column(name = "ocena")
    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracaDomowaEntity that = (PracaDomowaEntity) o;

        if (idpracaDomowa != that.idpracaDomowa) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;
        if (tytul != null ? !tytul.equals(that.tytul) : that.tytul != null) return false;
        if (tresc != null ? !tresc.equals(that.tresc) : that.tresc != null) return false;
        if (dzien != null ? !dzien.equals(that.dzien) : that.dzien != null) return false;
        if (ocena != null ? !ocena.equals(that.ocena) : that.ocena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpracaDomowa;
        result = 31 * result + zajeciaIdzajecia;
        result = 31 * result + (tytul != null ? tytul.hashCode() : 0);
        result = 31 * result + (tresc != null ? tresc.hashCode() : 0);
        result = 31 * result + (dzien != null ? dzien.hashCode() : 0);
        result = 31 * result + (ocena != null ? ocena.hashCode() : 0);
        return result;
    }
}
