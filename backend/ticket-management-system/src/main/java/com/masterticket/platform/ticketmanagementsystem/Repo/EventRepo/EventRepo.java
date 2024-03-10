package com.masterticket.platform.ticketmanagementsystem.Repo.EventRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Events.Event;

public interface EventRepo extends JpaRepository<Event, Long> {
    
}
