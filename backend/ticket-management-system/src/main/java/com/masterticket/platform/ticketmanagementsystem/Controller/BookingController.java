package com.masterticket.platform.ticketmanagementsystem.Controller;

import com.masterticket.platform.ticketmanagementsystem.Models.DTO.UserRequest;
import com.masterticket.platform.ticketmanagementsystem.Models.User;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.CreateBookingDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.CreateTicketsDTO;
import com.masterticket.platform.ticketmanagementsystem.Services.BookingService;
import com.masterticket.platform.ticketmanagementsystem.Services.IssuedTicketService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;
    private final IssuedTicketService issuedTicketService;

    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse createBooking(@RequestBody CreateBookingDTO createBookingDTO) {
        return bookingService.createBooking(createBookingDTO.customerID(), createBookingDTO.eventID(), createBookingDTO.numTicketsPerCat());
    }

    @PostMapping("/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTickets(@RequestBody CreateTicketsDTO createTicketsDTO) {
        issuedTicketService.createTicketsForABooking(createTicketsDTO.bookingID(), createTicketsDTO.numTicketsPerCat());
        bookingService.confirmBooking(createTicketsDTO.bookingID());
    }

}
