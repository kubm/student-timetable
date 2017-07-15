package com.kubacki.services;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.domain.Zajecia;
import com.kubacki.repositories.ZajeciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Service
public class ZajeciaServiceImpl implements ZajeciaService{

    private ZajeciaRepository zajeciaRepository;

    @Autowired
    public void setZajeciaRepository(ZajeciaRepository zajeciaRepository){
        this.zajeciaRepository = zajeciaRepository;
    }

    @Override
    public List<Zajecia> findByPrzedmiot(Przedmiot przedmiot){
        return zajeciaRepository.findByPrzedmiot(przedmiot);
    }

    @Override
    public List<Zajecia> findByTypZajec(TypZajec typZajec) {
        return zajeciaRepository.findByTypZajec(typZajec);
    }

    public Zajecia getById(Integer id){
        return zajeciaRepository.findOne(id);
    }

    @Override
    public Zajecia saveOrUpdate(Zajecia domainObject) {
        return zajeciaRepository.save(domainObject);
    }

    public void delete(Integer id){
        zajeciaRepository.delete(id);
    }

    public Iterable<Zajecia> listAll(){
        return zajeciaRepository.findAll();
    }

}
