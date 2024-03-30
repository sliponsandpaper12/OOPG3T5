package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    private Integer bookingID;
    private LocalDateTime timestamp;
    private Integer eventId;
    private Integer userId;
    private double amountPaid;
    private boolean isRefunded;
    private int numberOfTickets;
}
