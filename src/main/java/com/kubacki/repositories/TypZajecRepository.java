package com.kubacki.repositories;

import com.kubacki.domain.TypZajec;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface TypZajecRepository extends CrudRepository<TypZajec,Integer> {
    TypZajec findByNazwa(String nazwa);
}
