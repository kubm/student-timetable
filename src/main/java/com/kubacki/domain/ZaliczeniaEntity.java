package com.kubacki.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "zaliczenia", schema = "mydb", catalog = "")
@IdClass(ZaliczeniaEntityPK.class)
public class ZaliczeniaEntity {
    private int idzaliczenia;
    private int zajeciaIdzajecia;
    private int typZaliczeniaIdtypZaliczenia;
    private int salaIdsala;
    private Timestamp dzien;
    private Integer ocena;
    private TypZaliczeniaEntity typZaliczeniaByTypZaliczeniaIdtypZaliczenia;
    private SalaEntity salaBySalaIdsala;

    @Id
    @Column(name = "idzaliczenia")
    public int getIdzaliczenia() {
        return idzaliczenia;
    }

    public void setIdzaliczenia(int idzaliczenia) {
        this.idzaliczenia = idzaliczenia;
    }

    @Id
    @Column(name = "zajecia_idzajecia")
    public int getZajeciaIdzajecia() {
        return zajeciaIdzajecia;
    }

    public void setZajeciaIdzajecia(int zajeciaIdzajecia) {
        this.zajeciaIdzajecia = zajeciaIdzajecia;
    }

    @Id
    @Column(name = "typ_zaliczenia_idtyp_zaliczenia")
    public int getTypZaliczeniaIdtypZaliczenia() {
        return typZaliczeniaIdtypZaliczenia;
    }

    public void setTypZaliczeniaIdtypZaliczenia(int typZaliczeniaIdtypZaliczenia) {
        this.typZaliczeniaIdtypZaliczenia = typZaliczeniaIdtypZaliczenia;
    }

    @Id
    @Column(name = "sala_idsala")
    public int getSalaIdsala() {
        return salaIdsala;
    }

    public void setSalaIdsala(int salaIdsala) {
        this.salaIdsala = salaIdsala;
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

        ZaliczeniaEntity that = (ZaliczeniaEntity) o;

        if (idzaliczenia != that.idzaliczenia) return false;
        if (zajeciaIdzajecia != that.zajeciaIdzajecia) return false;
        if (typZaliczeniaIdtypZaliczenia != that.typZaliczeniaIdtypZaliczenia) return false;
        if (salaIdsala != that.salaIdsala) return false;
        if (dzien != null ? !dzien.equals(that.dzien) : that.dzien != null) return false;
        if (ocena != null ? !ocena.equals(that.ocena) : that.ocena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idzaliczenia;
        result = 31 * result + zajeciaIdzajecia;
        result = 31 * result + typZaliczeniaIdtypZaliczenia;
        result = 31 * result + salaIdsala;
        result = 31 * result + (dzien != null ? dzien.hashCode() : 0);
        result = 31 * result + (ocena != null ? ocena.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "typ_zaliczenia_idtyp_zaliczenia", referencedColumnName = "idtyp_zaliczenia", nullable = false)
    public TypZaliczeniaEntity getTypZaliczeniaByTypZaliczeniaIdtypZaliczenia() {
        return typZaliczeniaByTypZaliczeniaIdtypZaliczenia;
    }

    public void setTypZaliczeniaByTypZaliczeniaIdtypZaliczenia(TypZaliczeniaEntity typZaliczeniaByTypZaliczeniaIdtypZaliczenia) {
        this.typZaliczeniaByTypZaliczeniaIdtypZaliczenia = typZaliczeniaByTypZaliczeniaIdtypZaliczenia;
    }

    @ManyToOne
    @JoinColumn(name = "sala_idsala", referencedColumnName = "idsala", nullable = false)
    public SalaEntity getSalaBySalaIdsala() {
        return salaBySalaIdsala;
    }

    public void setSalaBySalaIdsala(SalaEntity salaBySalaIdsala) {
        this.salaBySalaIdsala = salaBySalaIdsala;
    }
}
