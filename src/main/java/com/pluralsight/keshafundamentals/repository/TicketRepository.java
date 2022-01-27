package com.pluralsight.keshafundamentals.repository;


import com.pluralsight.keshafundamentals.entity.Ticket;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
