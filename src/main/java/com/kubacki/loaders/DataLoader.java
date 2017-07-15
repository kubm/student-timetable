package com.kubacki.loaders;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.domain.Zajecia;
import com.kubacki.repositories.PrzedmiotRepository;
import com.kubacki.repositories.TypZajecRepository;
import com.kubacki.repositories.ZajeciaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private ZajeciaRepository zajeciaRepository;
    private PrzedmiotRepository przedmiotRepository;
    private TypZajecRepository typZajecRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    public void setZajeciaRepository(ZajeciaRepository zajeciaRepository){
        this.zajeciaRepository = zajeciaRepository;
    }

    @Autowired
    public void setPrzedmiotRepository(PrzedmiotRepository przedmiotRepository){
        this.przedmiotRepository = przedmiotRepository;
    }

    @Autowired
    public void setTypZajecRepository(TypZajecRepository typZajecRepository){
        this.typZajecRepository = typZajecRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        TypZajec lectures = new TypZajec();
        lectures.setNazwa("wykłady");
        typZajecRepository.save(lectures);
        log.info("Saved lectures");

        TypZajec cwiczenia = new TypZajec();
        cwiczenia.setNazwa("ćwiczenia");
        typZajecRepository.save(cwiczenia);
        log.info("Saved cwiczenia");

        TypZajec labs = new TypZajec();
        labs.setNazwa("laboratoria");
        typZajecRepository.save(labs);
        log.info("Saved labs");


        Przedmiot analiza = new Przedmiot();
        analiza.setNazwa("Analiza Matematyczna");
        analiza.setKolor("pommegranate");
        przedmiotRepository.save(analiza);
        log.info("Saved Analiza Matematyczna");

        Zajecia cwiczenia_a = new Zajecia();
        cwiczenia_a.setPrzedmiot(analiza);
        cwiczenia_a.setDzien_tygodnia("Wtorek");
        cwiczenia_a.setTypZajec(cwiczenia);
        zajeciaRepository.save(cwiczenia_a);
        log.info("Saved cwiczenia");

        Zajecia wyklad_a = new Zajecia();
        wyklad_a.setPrzedmiot(analiza);
        wyklad_a.setDzien_tygodnia("Poniedziałek");
        wyklad_a.setTypZajec(lectures);
        zajeciaRepository.save(wyklad_a);
        log.info("Saved wyklad");
    }
}
