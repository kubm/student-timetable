package com.kubacki.domain;



import javax.persistence.*;
import java.util.Date;
import com.kubacki.domain.TypZajec;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Zajecia implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "typ_id")
    private TypZajec typZajec;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id")
    private Przedmiot przedmiot;

    private String dzien_tygodnia;

    @Column(name = "START_DATE", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Column(name = "END_DATE", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

    public String getDzien_tygodnia() {
        return dzien_tygodnia;
    }

    public void setDzien_tygodnia(String dzien_tygodnia) {
        this.dzien_tygodnia = dzien_tygodnia;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public TypZajec getTypZajec(){
        return typZajec;
    }

    public void setTypZajec(TypZajec typZajec){
        this.typZajec = typZajec;
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
