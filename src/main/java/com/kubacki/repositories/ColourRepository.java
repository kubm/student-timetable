package com.kubacki.repositories;

import com.kubacki.domain.Colour;
import org.springframework.data.repository.CrudRepository;

public interface ColourRepository extends CrudRepository<Colour, Integer>{
    Colour findByName(String nazwa);
}
