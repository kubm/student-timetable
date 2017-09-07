package com.kubacki.services;

import com.kubacki.domain.EventList;
import com.kubacki.repositories.EventPrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventPrinterServiceImpl implements EventPrinterService{
    private EventPrinterRepository eventPrinterRepository;

    @Autowired
    public void setEventPrinterRepository(EventPrinterRepository eventPrinterRepository) {
        this.eventPrinterRepository = eventPrinterRepository;
    }

    @Override
    public List<EventList> findByQuery(Integer id) {
        return eventPrinterRepository.findEventsQuery(id);
    }
}
