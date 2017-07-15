package com.kubacki.services;

import com.kubacki.domain.TypZajec;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface TypZajecService extends CRUDService<TypZajec>{

    TypZajec findByNazwa(String nazwa);
}
