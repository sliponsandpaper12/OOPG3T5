package com.masterticket.platform.ticketmanagementsystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventDTO;
import com.masterticket.platform.ticketmanagementsystem.Repo.EventRepo;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventStatisticsResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventUpdateDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.EventCategory;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.CancelEventResponseDTO;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepo eventRepo;
    private final EventCategoryService eventCategoryService;
    private final BookingService bookingService;

    public Event toEvent(EventDTO eventDTO) {
        var event = new Event();
        event.setName(eventDTO.name());
        event.setVenue(eventDTO.venue());
        event.setDate(eventDTO.date());
        event.setStartTime(eventDTO.startTime());
        event.setEndTime(eventDTO.endTime());

        return event;
    }

    public EventDTO toEventDTO(Event event) {
        return new EventDTO(event.getName(), event.getVenue(), event.getDate(), event.getStartTime(),
                event.getEndTime());
    }

    public EventResponseDTO toEventResponseDTO(Event event) {
        return new EventResponseDTO(event.getEventID(), event.getName());
    }

    public EventResponseDTO createEvent(EventDTO eventDTO) {
        var savedEvent = eventRepo.save(toEvent(eventDTO));
        return toEventResponseDTO(savedEvent);
    }

    public EventResponseDTO updateEvent(EventUpdateDTO eventUpdateDTO) {
        var eventInDb = eventRepo.getReferenceById(eventUpdateDTO.eventID());
        eventInDb.setName(eventUpdateDTO.name());
        eventInDb.setDate(eventUpdateDTO.date());
        eventInDb.setStartTime(eventUpdateDTO.startTime());
        eventInDb.setEndTime(eventUpdateDTO.endTime());
        eventInDb.setVenue(eventUpdateDTO.venue());
        eventRepo.save(eventInDb);
        return toEventResponseDTO(eventInDb);
    }

    public EventStatisticsResponseDTO getStatistics(Integer eventID) {
        Map<Character, Map<String, Double>> eventStatistics = new HashMap<>();
        var eventInDb = eventRepo.getReferenceById(eventID);
        List<EventCategory> eventCategories = eventInDb.getEventCategories();
        for (EventCategory eventCategory : eventCategories) {
            eventStatistics.put(eventCategory.getCategory(), eventCategoryService.getCategoryStatistics(eventCategory));
        }
        return new EventStatisticsResponseDTO(eventStatistics);
    }

    public CancelEventResponseDTO cancelEvent(Integer eventID) {
        var eventInDb = eventRepo.getReferenceById(eventID);
        eventInDb.setCancelled(true);
        eventRepo.save(eventInDb);
        int numTicketsRefunded = 0;
        double totalRefundAmt = 0.0;
        for (Booking booking : eventInDb.getBookings()) {
            Double[] refundBookingResult = bookingService.refundBooking(booking.getBookingID());
            numTicketsRefunded += refundBookingResult[1];
            totalRefundAmt += refundBookingResult[0];
        }
        return new CancelEventResponseDTO(eventID, eventInDb.getName(), numTicketsRefunded, totalRefundAmt);
    }

    public List<Event> findAll() {
        // testing for CSV
        // Will provide hardcoded data in main
        return (List<Event>) eventRepo.findAll();
    }
}
