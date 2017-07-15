package com.kubacki.services;

import com.kubacki.domain.Przedmiot;
import com.kubacki.repositories.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Service
public class PrzedmiotServiceImpl implements PrzedmiotService{
    private PrzedmiotRepository przedmiotRepository;

    @Autowired
    public void setPrzedmiotRepository(PrzedmiotRepository przedmiotRepository){
        this.przedmiotRepository = przedmiotRepository;
    }

    @Override
    public Iterable<Przedmiot> listAll(){
        return przedmiotRepository.findAll();
    }

    @Override
    public Przedmiot getById(Integer id){
        return przedmiotRepository.findOne(id);
    }

    @Override
    public Przedmiot saveOrUpdate(Przedmiot domainObject) {
        return przedmiotRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        przedmiotRepository.delete(id);
    }

    @Override
    public Przedmiot findByNazwa(String nazwa){
        return przedmiotRepository.findByNazwa(nazwa);
    }


}
