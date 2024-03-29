package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

import java.util.Map;

public record CreateTicketsDTO(
    Integer bookingID,
    Map<Integer,Integer> numTicketsPerCat
) {
    
}
