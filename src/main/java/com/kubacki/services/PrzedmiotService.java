package com.kubacki.services;

import com.kubacki.domain.Przedmiot;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface PrzedmiotService extends CRUDService<Przedmiot>{

    Przedmiot findByNazwa(String nazwa);
}
