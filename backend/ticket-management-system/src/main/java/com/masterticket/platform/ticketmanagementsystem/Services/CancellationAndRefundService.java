package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;
import com.masterticket.platform.ticketmanagementsystem.Repo.EventCategoryRepo;

@Service
public class CancellationAndRefundService {

    private final BookingRepo bookingRepo;
    private final BookingService bookingService;
    private final EventCategoryRepo eventCategoryRepo;

    @Autowired
    public CancellationAndRefundService(BookingRepo bookingRepo, BookingService bookingService, EventCategoryRepo eventCategoryRepo) {
        this.bookingRepo = bookingRepo;
        this.bookingService = bookingService;
        this.eventCategoryRepo = eventCategoryRepo;
    }

    @Transactional
    public String cancelAndRefund(Integer bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
            .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        // check if less than 48 hours b4 event
        if (LocalDateTime.now().plusHours(48).isAfter(booking.getEvent().getStartTime().atDate(booking.getEvent().getDate()))) {
            return "It is too late to cancel the booking. Cancellations must be made at least 48 hours before the start of the event.";
        }

        Double[] refundDetails = bookingService.refundBooking(bookingId);

        // update eventcategory
        updateEventCategoryTicketsSold(booking.getEvent().getEventID(), -refundDetails[1].intValue());

        return "Booking cancelled and refund processed successfully.";
    }

    private void updateEventCategoryTicketsSold(Integer eventId, int ticketsToSubtract) {
        eventCategoryRepo.findByEventId(eventId).forEach(category -> {
            int newTotal = Math.max(0, category.getTotalNumTicketsSold() - ticketsToSubtract);
            category.setTotalNumTicketsSold(newTotal);
            eventCategoryRepo.save(category);
        });
    }

    
    private final EventService eventService;
    private final UserRepo userRepo;

    @Autowired
    public EmCancellationAndRefundService(EventService eventService, BookingService bookingService, UserRepo userRepo) {
        this.eventService = eventService;
        this.bookingService = bookingService;
        this.userRepo = userRepo;
    }

    @Transactional
    public void emCancelAndRefundEvent(Integer eventId, Integer userId) {
        if (!isEventManager(userId)) {
            throw new RuntimeException("User is not authorized to cancel the event."); // Use an appropriate exception
        }

        
        eventService.cancelEvent(eventId);

        //refund
        var eventInDb = eventRepo.getReferenceById(eventId);
        for (Booking booking : eventInDb.getBookings()) {
            bookingService.refundBooking(booking.getBookingID());
        }
    }


    public boolean isEventManager(Integer userId) {
        var user = userRepo.getReferenceById(userId);
        return user.getType() == 'E'; // assume e is em
    }

}
