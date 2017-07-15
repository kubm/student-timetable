package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "typ_zajec", schema = "mydb", catalog = "")
public class TypZajecEntity {
    private int idtypZajec;
    private String nazwa;

    @Id
    @Column(name = "idtyp_zajec")
    public int getIdtypZajec() {
        return idtypZajec;
    }

    public void setIdtypZajec(int idtypZajec) {
        this.idtypZajec = idtypZajec;
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

        TypZajecEntity that = (TypZajecEntity) o;

        if (idtypZajec != that.idtypZajec) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtypZajec;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
