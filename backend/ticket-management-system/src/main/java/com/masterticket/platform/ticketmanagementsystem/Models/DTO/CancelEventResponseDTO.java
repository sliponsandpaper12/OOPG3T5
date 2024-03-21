package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

public record CancelEventResponseDTO(
    Integer eventID,
    String name, 
    Integer numTicketsRefunded,
    double totalRefundAmt
) {
    
}
