package com.masterticket.platform.ticketmanagementsystem.Repo.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.User.TicketingOfficer;

public interface TicketingOfficerRepo extends JpaRepository<TicketingOfficer, Long> {
    
}
