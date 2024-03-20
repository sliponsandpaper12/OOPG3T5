package com.masterticket.platform.ticketmanagementsystem.Models.DTO;
import java.time.LocalDate;
import java.time.LocalTime;

public record EventUpdateDTO(
    Integer eventID,
    String name,
    LocalDate date,
    LocalTime startTime,
    LocalTime endTime,
    String venue
) {
    
}
