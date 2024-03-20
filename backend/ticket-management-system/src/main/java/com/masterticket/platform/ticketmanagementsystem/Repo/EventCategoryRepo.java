package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.EventCategory;

public interface EventCategoryRepo extends JpaRepository<EventCategory, Long> {
    
}
