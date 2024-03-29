package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

import java.util.Map;

public record CreateBookingDTO(
    Integer eventID,
    Integer customerID,
    Map<Integer,Integer> numTicketsPerCat
) {
    
}
