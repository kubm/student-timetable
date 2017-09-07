package com.kubacki.services;

import com.kubacki.domain.EventList;

import java.util.List;

public interface EventPrinterService {
    public List<EventList> findByQuery(Integer id);
}
