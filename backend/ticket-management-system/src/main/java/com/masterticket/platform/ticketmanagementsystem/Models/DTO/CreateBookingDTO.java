package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

public record CreateBookingDTO(
    Integer numOfTickets,
    Integer userId,
    Integer eventId,
    double amountPaid,
    boolean isRefunded
) {
    
}
