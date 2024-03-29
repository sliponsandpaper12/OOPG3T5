package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Repo.IssuedTicketRepo;

import lombok.AllArgsConstructor;

import java.util.*;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Models.EventCategory;
import com.masterticket.platform.ticketmanagementsystem.Models.IssuedTicket;

@Service
@AllArgsConstructor
public class IssuedTicketService {
    
    private final IssuedTicketRepo issuedTicketRepo;
    private final EventCategoryService eventCategoryService;
    private final BookingService bookingService;

    public void createTicketsForABooking(Integer bookingId, Map<Integer, Integer> numTicketsPerCat) {

        Booking booking = new Booking();
        booking.setBookingID(bookingId);

        double totalBookingPrice = 0;
        Integer totalTickets = 0;

        for (Map.Entry<Integer,Integer> entry : numTicketsPerCat.entrySet()) {

            Integer eventCatId = entry.getKey();
            Integer numTickets = entry.getValue();
            EventCategory eventCat = new EventCategory();
            eventCat.setEventCategoryID(eventCatId);

            totalTickets += numTickets;

            double price = eventCategoryService.getEventCategoryById(eventCatId).getPrice();

            for (int i =0; i < numTickets;i++) {
                IssuedTicket ticket = new IssuedTicket(true);
                ticket.setBooking(booking);
                ticket.setEventCategory(eventCat);
                ticket.setPrice(price);

                issuedTicketRepo.save(ticket);

                totalBookingPrice += price;
            }
        }

        bookingService.setBookingAmtPaid(bookingId, totalBookingPrice);
        eventCategoryService.sellTickets(totalTickets, (Integer) numTicketsPerCat.keySet().toArray()[0]);
    }

    
}
