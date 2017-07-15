package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "wykladowcy", schema = "mydb", catalog = "")
public class WykladowcyEntity {
    private int idwykladowcy;
    private String imie;
    private String nazwisko;
    private String eMail;
    private String telefon;

    @Id
    @Column(name = "idwykladowcy")
    public int getIdwykladowcy() {
        return idwykladowcy;
    }

    public void setIdwykladowcy(int idwykladowcy) {
        this.idwykladowcy = idwykladowcy;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "e-mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "telefon")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WykladowcyEntity that = (WykladowcyEntity) o;

        if (idwykladowcy != that.idwykladowcy) return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(that.nazwisko) : that.nazwisko != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idwykladowcy;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        return result;
    }
}
