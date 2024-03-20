package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

public record EventCategoryDTO(
    char category,
    double price,
    int totalNumTickets,
    int eventID
) {
    
}
