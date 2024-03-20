package com.masterticket.platform.ticketmanagementsystem.Models.DTO;
import java.time.LocalDate;
import java.time.LocalTime;

public record EventDTO(
    String name,
    String venue, 
    LocalDate date,
    LocalTime startTime,
    LocalTime endTime
) {
    
}

