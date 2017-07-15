package com.kubacki.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
@Table(name = "zajecia", schema = "mydb", catalog = "")
@IdClass(ZajeciaEntityPK.class)
public class ZajeciaEntity {
    private int idzajecia;
    private int przedmiotIdprzedmiot;
    private int typZajecIdtypZajec;
    private int salaIdsala;
    private int wykladowcyIdwykladowcy;
    private int dzienTygodnia;
    private Timestamp startDate;
    private Timestamp endDate;
    private NotatkiEntity notatkiByIdzajecia;
    private PracaDomowaEntity pracaDomowaByIdzajecia;
    private PrzedmiotEntity przedmiotByPrzedmiotIdprzedmiot;
    private TypZajecEntity typZajecByTypZajecIdtypZajec;
    private SalaEntity salaBySalaIdsala;
    private WykladowcyEntity wykladowcyByWykladowcyIdwykladowcy;

    @Id
    @Column(name = "idzajecia")
    public int getIdzajecia() {
        return idzajecia;
    }

    public void setIdzajecia(int idzajecia) {
        this.idzajecia = idzajecia;
    }

    @Id
    @Column(name = "przedmiot_idprzedmiot")
    public int getPrzedmiotIdprzedmiot() {
        return przedmiotIdprzedmiot;
    }

    public void setPrzedmiotIdprzedmiot(int przedmiotIdprzedmiot) {
        this.przedmiotIdprzedmiot = przedmiotIdprzedmiot;
    }

    @Id
    @Column(name = "typ_zajec_idtyp_zajec")
    public int getTypZajecIdtypZajec() {
        return typZajecIdtypZajec;
    }

    public void setTypZajecIdtypZajec(int typZajecIdtypZajec) {
        this.typZajecIdtypZajec = typZajecIdtypZajec;
    }

    @Id
    @Column(name = "sala_idsala")
    public int getSalaIdsala() {
        return salaIdsala;
    }

    public void setSalaIdsala(int salaIdsala) {
        this.salaIdsala = salaIdsala;
    }

    @Id
    @Column(name = "wykladowcy_idwykladowcy")
    public int getWykladowcyIdwykladowcy() {
        return wykladowcyIdwykladowcy;
    }

    public void setWykladowcyIdwykladowcy(int wykladowcyIdwykladowcy) {
        this.wykladowcyIdwykladowcy = wykladowcyIdwykladowcy;
    }

    @Basic
    @Column(name = "dzien_tygodnia")
    public int getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(int dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZajeciaEntity that = (ZajeciaEntity) o;

        if (idzajecia != that.idzajecia) return false;
        if (przedmiotIdprzedmiot != that.przedmiotIdprzedmiot) return false;
        if (typZajecIdtypZajec != that.typZajecIdtypZajec) return false;
        if (salaIdsala != that.salaIdsala) return false;
        if (wykladowcyIdwykladowcy != that.wykladowcyIdwykladowcy) return false;
        if (dzienTygodnia != that.dzienTygodnia) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idzajecia;
        result = 31 * result + przedmiotIdprzedmiot;
        result = 31 * result + typZajecIdtypZajec;
        result = 31 * result + salaIdsala;
        result = 31 * result + wykladowcyIdwykladowcy;
        result = 31 * result + dzienTygodnia;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idzajecia", referencedColumnName = "zajecia_idzajecia", nullable = false)
    public NotatkiEntity getNotatkiByIdzajecia() {
        return notatkiByIdzajecia;
    }

    public void setNotatkiByIdzajecia(NotatkiEntity notatkiByIdzajecia) {
        this.notatkiByIdzajecia = notatkiByIdzajecia;
    }

    @ManyToOne
    @JoinColumn(name = "idzajecia", referencedColumnName = "zajecia_idzajecia", nullable = false)
    public PracaDomowaEntity getPracaDomowaByIdzajecia() {
        return pracaDomowaByIdzajecia;
    }

    public void setPracaDomowaByIdzajecia(PracaDomowaEntity pracaDomowaByIdzajecia) {
        this.pracaDomowaByIdzajecia = pracaDomowaByIdzajecia;
    }

    @ManyToOne
    @JoinColumn(name = "przedmiot_idprzedmiot", referencedColumnName = "idprzedmiot", nullable = false)
    public PrzedmiotEntity getPrzedmiotByPrzedmiotIdprzedmiot() {
        return przedmiotByPrzedmiotIdprzedmiot;
    }

    public void setPrzedmiotByPrzedmiotIdprzedmiot(PrzedmiotEntity przedmiotByPrzedmiotIdprzedmiot) {
        this.przedmiotByPrzedmiotIdprzedmiot = przedmiotByPrzedmiotIdprzedmiot;
    }

    @ManyToOne
    @JoinColumn(name = "typ_zajec_idtyp_zajec", referencedColumnName = "idtyp_zajec", nullable = false)
    public TypZajecEntity getTypZajecByTypZajecIdtypZajec() {
        return typZajecByTypZajecIdtypZajec;
    }

    public void setTypZajecByTypZajecIdtypZajec(TypZajecEntity typZajecByTypZajecIdtypZajec) {
        this.typZajecByTypZajecIdtypZajec = typZajecByTypZajecIdtypZajec;
    }

    @ManyToOne
    @JoinColumn(name = "sala_idsala", referencedColumnName = "idsala", nullable = false)
    public SalaEntity getSalaBySalaIdsala() {
        return salaBySalaIdsala;
    }

    public void setSalaBySalaIdsala(SalaEntity salaBySalaIdsala) {
        this.salaBySalaIdsala = salaBySalaIdsala;
    }

    @ManyToOne
    @JoinColumn(name = "wykladowcy_idwykladowcy", referencedColumnName = "idwykladowcy", nullable = false)
    public WykladowcyEntity getWykladowcyByWykladowcyIdwykladowcy() {
        return wykladowcyByWykladowcyIdwykladowcy;
    }

    public void setWykladowcyByWykladowcyIdwykladowcy(WykladowcyEntity wykladowcyByWykladowcyIdwykladowcy) {
        this.wykladowcyByWykladowcyIdwykladowcy = wykladowcyByWykladowcyIdwykladowcy;
    }
}
