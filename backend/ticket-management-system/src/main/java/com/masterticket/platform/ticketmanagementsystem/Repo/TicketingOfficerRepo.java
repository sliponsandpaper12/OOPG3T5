package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.TicketingOfficer;

public interface TicketingOfficerRepo extends JpaRepository<TicketingOfficer, Integer> {
    
}
