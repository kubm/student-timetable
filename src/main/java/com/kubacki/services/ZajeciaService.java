package com.kubacki.services;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.domain.Zajecia;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface ZajeciaService extends CRUDService<Zajecia>{

    List<Zajecia> findByPrzedmiot(Przedmiot przedmiot);
    List<Zajecia> findByTypZajec(TypZajec typZajec);
}
