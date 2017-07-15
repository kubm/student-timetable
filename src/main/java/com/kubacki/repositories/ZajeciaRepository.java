package com.kubacki.repositories;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.domain.Zajecia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface ZajeciaRepository extends CrudRepository<Zajecia,Integer>{
    List<Zajecia> findByPrzedmiot(Przedmiot przedmiot);
    List<Zajecia> findByTypZajec(TypZajec typZajec);

}
