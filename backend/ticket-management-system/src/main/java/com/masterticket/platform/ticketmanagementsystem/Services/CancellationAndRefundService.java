package com.masterticket.platform.ticketmanagementsystem.Services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Models.EventCategory;
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

    public String cancelAndRefund(Integer bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
            .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        // Check if less than 48 hours b4 event
        if (LocalDateTime.now().plusHours(48).isAfter(booking.getEvent().getStartTime().atDate(booking.getEvent().getDate()))) {
            return "It is too late to cancel the booking. Cancellations must be made at least 48 hours before the start of the event.";
        }

        Double[] refundDetails = bookingService.refundBooking(bookingId);

        // Update EventCategory
        updateEventCategoryTicketsSold(booking.getEvent().getEventID(), -refundDetails[1].intValue());

        return "Booking cancelled and refund processed successfully.";
    }

    private void updateEventCategoryTicketsSold(Integer eventId, int ticketsToSubtract) {
        List<EventCategory> eventCategories = eventCategoryRepo.findByEventId(eventId);
        for (EventCategory category : eventCategories) {
            category.setTotalNumTicketsSold(Math.max(0, category.getTotalNumTicketsSold() - ticketsToSubtract));
            eventCategoryRepo.save(category);
        }
    }
}
