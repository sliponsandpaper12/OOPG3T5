package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.IssuedTicket;

public interface IssuedTicketRepo extends JpaRepository<IssuedTicket, Integer> {
    
}
