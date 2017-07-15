package com.kubacki.repositories;

import com.kubacki.domain.Przedmiot;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface PrzedmiotRepository extends CrudRepository<Przedmiot,Integer>{
    Przedmiot findByNazwa(String nazwa);
}
