package com.kubacki.services;

import com.kubacki.domain.Colour;

public interface ColourService extends CRUDService<Colour>{
    Colour findByName(String name);
}
