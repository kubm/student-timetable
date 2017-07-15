package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Przedmiot implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nazwa;
    private String kolor;

    @OneToMany(mappedBy = "przedmiot")
    Set<Zajecia> zajecia;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public Set<Zajecia> getZajecia() {
        return zajecia;
    }


    public void addZajecia(Zajecia zajecia){
        this.zajecia.add(zajecia);
        if(zajecia.getPrzedmiot() != this){
            zajecia.setPrzedmiot(this);
        }
    }
}
