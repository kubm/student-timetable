package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "przedmiot", schema = "mydb", catalog = "")
public class PrzedmiotEntity {
    private int idprzedmiot;
    private String nazwa;
    private String kolor;

    @Id
    @Column(name = "idprzedmiot")
    public int getIdprzedmiot() {
        return idprzedmiot;
    }

    public void setIdprzedmiot(int idprzedmiot) {
        this.idprzedmiot = idprzedmiot;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "kolor")
    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrzedmiotEntity that = (PrzedmiotEntity) o;

        if (idprzedmiot != that.idprzedmiot) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (kolor != null ? !kolor.equals(that.kolor) : that.kolor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idprzedmiot;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (kolor != null ? kolor.hashCode() : 0);
        return result;
    }
}
