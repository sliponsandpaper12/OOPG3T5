package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Event;

public interface EventRepo extends JpaRepository<Event, Long> {
    
}
