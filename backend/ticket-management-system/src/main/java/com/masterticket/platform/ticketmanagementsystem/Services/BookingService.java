package com.masterticket.platform.ticketmanagementsystem.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.TransformService;

import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Models.IssuedTicket;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.BookingDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.CreateBookingDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.Exceptions.NotEnoughTicketException;
import com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;
    private final UserService userService;
    private final EventService eventService;
    private final TransformService ticketService;

    public boolean makeBooking(CreateBookingDTO createBookingDTO) throws NotEnoughTicketException{

        if(eventService.getEventById(createBookingDTO.eventId()).getTotalAvailableTickets() < createBookingDTO.numOfTickets()){
            throw new NotEnoughTicketException();
        } 

        Booking booking = new Booking();
        Booking savedBooking = bookingRepo.save(booking);
        savedBooking.setEvent(eventService.getEventById(createBookingDTO.eventId()));
        savedBooking.setUser(userService.getUserById(createBookingDTO.userId()));
        savedBooking.setTimestamp(LocalDateTime.now());
        List<IssuedTicket> tickets = new ArrayList<>();
        // for (int i=0; i < createBookingDTO.numOfTickets(); i++){
        //     tickets.add()
        // }

        return true;
    }

    public Double[] refundBooking(Integer bookingID) {
        var bookingInDb = bookingRepo.getReferenceById(bookingID);
        var user = bookingInDb.getUser();
        userService.refundUser(user.getUserID(), bookingInDb.getAmountPaid());
        bookingInDb.setRefunded(true);
        bookingRepo.save(bookingInDb);
        return new Double[] {
                bookingInDb.getAmountPaid(),
                (double) bookingInDb.getTickets().size()
        };
    }
}
