package com.kubacki.domain;

import com.sun.org.apache.xalan.internal.xsltc.DOM;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Zajecia implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id")
    public Przedmiot przedmiot;

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
