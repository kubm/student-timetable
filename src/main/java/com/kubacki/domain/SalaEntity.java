package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "sala", schema = "mydb", catalog = "")
public class SalaEntity {
    private int idsala;
    private String nrPokoju;
    private String budynek;

    @Id
    @Column(name = "idsala")
    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    @Basic
    @Column(name = "nr_pokoju")
    public String getNrPokoju() {
        return nrPokoju;
    }

    public void setNrPokoju(String nrPokoju) {
        this.nrPokoju = nrPokoju;
    }

    @Basic
    @Column(name = "budynek")
    public String getBudynek() {
        return budynek;
    }

    public void setBudynek(String budynek) {
        this.budynek = budynek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaEntity that = (SalaEntity) o;

        if (idsala != that.idsala) return false;
        if (nrPokoju != null ? !nrPokoju.equals(that.nrPokoju) : that.nrPokoju != null) return false;
        if (budynek != null ? !budynek.equals(that.budynek) : that.budynek != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsala;
        result = 31 * result + (nrPokoju != null ? nrPokoju.hashCode() : 0);
        result = 31 * result + (budynek != null ? budynek.hashCode() : 0);
        return result;
    }
}
