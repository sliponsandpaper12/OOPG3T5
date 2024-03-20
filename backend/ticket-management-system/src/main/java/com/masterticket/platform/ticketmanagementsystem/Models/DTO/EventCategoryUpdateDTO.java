package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

public record EventCategoryUpdateDTO(
    char category,
    double price,
    int totalNumTickets,
    int eventCategoryID
) {
    
}
