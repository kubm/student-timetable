package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "typ_zaliczenia", schema = "mydb", catalog = "")
public class TypZaliczeniaEntity {
    private int idtypZaliczenia;
    private String nazwa;

    @Id
    @Column(name = "idtyp_zaliczenia")
    public int getIdtypZaliczenia() {
        return idtypZaliczenia;
    }

    public void setIdtypZaliczenia(int idtypZaliczenia) {
        this.idtypZaliczenia = idtypZaliczenia;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypZaliczeniaEntity that = (TypZaliczeniaEntity) o;

        if (idtypZaliczenia != that.idtypZaliczenia) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtypZaliczenia;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
