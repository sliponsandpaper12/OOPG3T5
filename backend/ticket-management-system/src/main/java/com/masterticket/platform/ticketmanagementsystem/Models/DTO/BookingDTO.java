package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record BookingDTO(
    Integer id,
    LocalDateTime timestamp,
    List<Integer> ticketIds,
    Integer userId,
    Integer eventId,
    double amountPaid,
    boolean isRefunded
) {

}
