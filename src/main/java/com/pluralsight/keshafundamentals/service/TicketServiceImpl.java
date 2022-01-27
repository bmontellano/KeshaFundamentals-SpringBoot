package com.pluralsight.keshafundamentals.service;

import com.pluralsight.keshafundamentals.entity.Ticket;
import com.pluralsight.keshafundamentals.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Iterable<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

}
