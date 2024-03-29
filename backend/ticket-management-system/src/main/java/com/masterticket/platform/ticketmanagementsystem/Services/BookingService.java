package com.masterticket.platform.ticketmanagementsystem.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Models.Customer;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.IssuedTicket;
import com.masterticket.platform.ticketmanagementsystem.Models.User;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.CreateBookingDTO;
import com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;
import com.masterticket.platform.ticketmanagementsystem.Services.EmailNotification.EmailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;
    private final UserService userService;
    private final EventCategoryService eventCatService;
    private final CustomerService customerService;
    private final EmailService emailService;

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

    public AuthResponse createBooking(Integer customerId, Integer eventId, Map<Integer, Integer> numTicketsPerCat) {

        if (!isAmtSufficient(customerService.getCustomerById(customerId), numTicketsPerCat)){
            return new AuthResponse("Insufficient Balance in Account!", false);
        }

        if (!isTicketsSufficient(numTicketsPerCat)){
            return new AuthResponse("Insufficient Tickets", false);
        }

        if (!isBookingAvailable((Integer) numTicketsPerCat.keySet().toArray()[0])) {
            return new AuthResponse("Unable to book event at current time", false);
        }

        Event event = new Event();
        event.setEventID(eventId);

        User user = new User();
        user.setUserID(customerId);;

        Booking newBooking = new Booking(LocalDateTime.now(), false);
        newBooking.setEvent(event);
        newBooking.setUser(user);

        Booking savedBooking = bookingRepo.save(newBooking);
        String bookingId = savedBooking.getBookingID().toString();

        return new AuthResponse(bookingId, true);
    }

    public void confirmBooking(Integer bookingId) {
        Booking booking = bookingRepo.getReferenceById(bookingId);
        String email = customerService.getCustomerById(booking.getUser().getUserID()).getEmail();
        Event event = booking.getEvent();

        customerService.madePayment(booking.getUser().getUserID(), booking.getAmountPaid());

        String emailBody = "Successfully purchased Tickets fot Event: " + event.getName() + " at " + event.getVenue() 
        + " starting at " + event.getDate() + ", " + event.getStartTime()+"\n" + " \n";

        for (IssuedTicket ticket : booking.getTickets()) {
            emailBody += generateDetailsForTicket(ticket)+" \n";
        }

        emailService.sendNewMail(email, "Tickets confirmed!", emailBody);

    }

    public void setBookingAmtPaid(Integer bookingId, double amtPaid){
        Booking booking = bookingRepo.getReferenceById(bookingId);
        booking.setAmountPaid(amtPaid);
        bookingRepo.save(booking);
    }

    private boolean isAmtSufficient(Customer customer, Map<Integer, Integer> numTicketsPerCat) {

        double currentBalance = customer.getBalance();

        double amtPayable = 0;
        for (Map.Entry<Integer,Integer> entry : numTicketsPerCat.entrySet()) {
            amtPayable += eventCatService.getEventCategoryById(entry.getKey()).getPrice() * entry.getValue();
        }

        return currentBalance > amtPayable;
    }

    private boolean isTicketsSufficient(Map<Integer, Integer> numTicketsPerCat) {

        for (Map.Entry<Integer,Integer> entry : numTicketsPerCat.entrySet()) {

            int ticketsAvailable = eventCatService.getEventCategoryById(entry.getKey()).getTotalNumTickets() - eventCatService.getEventCategoryById(entry.getKey()).getTotalNumTicketsSold();
            return ticketsAvailable > entry.getValue();
        }

        return true;
    }

    private boolean isBookingAvailable(Integer eventCatId) {

        Event event = eventCatService.getEventByEventCatId(eventCatId);
        LocalDateTime eventDateTime = LocalDateTime.of(event.getDate() , event.getStartTime());
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (currentDateTime.isAfter(eventDateTime)){
            return false;
        }

        if (ChronoUnit.MONTHS.between(YearMonth.from(eventDateTime.toLocalDate()), YearMonth.from(currentDateTime.toLocalDate())) > 6
         || eventDateTime.until(currentDateTime, ChronoUnit.HOURS) < 24) {
            return false;
        }

        return true;
    }

    public String generateDetailsForTicket(IssuedTicket ticket){

    char category = ticket.getEventCategory().getCategory();
    return "TicketID: " + String.valueOf(ticket.getTicketID()) + " Price: " + String.valueOf(ticket.getPrice()) + " Category: " + category + "\n";

    }
}
