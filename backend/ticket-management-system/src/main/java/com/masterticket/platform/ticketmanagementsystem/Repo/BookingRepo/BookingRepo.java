package com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    
}
