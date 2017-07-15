package com.kubacki.services;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.repositories.TypZajecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class TypZajecServiceImpl implements TypZajecService{
    private TypZajecRepository typZajecRepository;

    @Autowired
    public void setTypZajecRepository(TypZajecRepository typZajecRepository){
        this.typZajecRepository = typZajecRepository;
    }

    @Override
    public Iterable<TypZajec> listAll(){
        return  typZajecRepository.findAll();
    }

    @Override
    public TypZajec getById(Integer id){
        return typZajecRepository.findOne(id);
    }

    @Override
    public TypZajec saveOrUpdate(TypZajec domainObject){
        return  typZajecRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        typZajecRepository.delete(id);
    }

    @Override
    public TypZajec findByNazwa(String nazwa){
        return typZajecRepository.findByNazwa(nazwa);
    }
}
