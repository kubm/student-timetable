package com.kubacki.domain;

import groovy.util.Eval;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class EvalType implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nazwa;

    @OneToMany(mappedBy = "evaluationType")
    private Set<Evaluation> evaluations;

    //-------------- Getters & Setters ---------------------------//


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

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void addEvaluation(Evaluation evaluation){
        this.evaluations.add(evaluation);
        if(evaluation.getEvaluationType() != this){
            evaluation.setEvaluationType(this);
        }
    }
}
