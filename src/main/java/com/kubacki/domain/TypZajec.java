package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class TypZajec implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nazwa;

    @OneToMany(mappedBy = "typZajec")
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

    public Set<Zajecia> getZajecia(){
        return zajecia;
    }

    public void addZajecia(Zajecia zajecia){
        this.zajecia.add(zajecia);
        if(zajecia.getTypZajec() != this){
            zajecia.setTypZajec(this);
        }
    }
}
