package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    
}
