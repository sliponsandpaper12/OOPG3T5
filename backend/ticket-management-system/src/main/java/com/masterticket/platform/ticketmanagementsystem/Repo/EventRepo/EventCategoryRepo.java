package com.masterticket.platform.ticketmanagementsystem.Repo.EventRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Events.EventCategory;

public interface EventCategoryRepo extends JpaRepository<EventCategory, Long> {
    
}
