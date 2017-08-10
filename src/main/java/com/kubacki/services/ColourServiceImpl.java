package com.kubacki.services;

import com.kubacki.domain.Colour;
import com.kubacki.domain.Subject;
import com.kubacki.repositories.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourServiceImpl implements ColourService{
    private ColourRepository colourRepository;

    @Autowired
    public void setColourRepository(ColourRepository colourRepository){
        this.colourRepository = colourRepository;
    }

    @Override
    public Iterable<Colour> listAll(){
        return colourRepository.findAll();
    }

    @Override
    public Colour getById(Integer id){
        return colourRepository.findOne(id);
    }

    @Override
    public Colour saveOrUpdate(Colour domainObject){
        return colourRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        colourRepository.delete(id);
    }

    @Override
    public Colour findByName(String name) {
        return colourRepository.findByName(name);
    }
}
