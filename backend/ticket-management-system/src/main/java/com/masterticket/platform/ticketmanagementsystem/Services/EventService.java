package com.masterticket.platform.ticketmanagementsystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Models.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventDTO;
import com.masterticket.platform.ticketmanagementsystem.Repo.EventRepo;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventUpdateDTO;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepo eventRepo;

    public Event toEvent(EventDTO eventDTO){
        var event = new Event();
        event.setName(eventDTO.name());
        event.setVenue(eventDTO.venue());
        event.setDate(eventDTO.date());
        event.setStartTime(eventDTO.startTime());
        event.setEndTime(eventDTO.endTime());

        return event;
    } 

    public EventDTO toEventDTO(Event event){
        return new EventDTO(event.getName(), event.getVenue(), event.getDate(), event.getStartTime(), event.getEndTime());
    }

    public EventResponseDTO toEventResponseDTO(Event event){
        return new EventResponseDTO(event.getEventID(), event.getName());
    }

    public EventResponseDTO createEvent(EventDTO eventDTO){
        var savedEvent = eventRepo.save(toEvent(eventDTO));
        return toEventResponseDTO(savedEvent);
    }

    public EventResponseDTO updateEvent(EventUpdateDTO eventUpdateDTO){
        var eventInDb = eventRepo.getReferenceById(eventUpdateDTO.eventID());
        eventInDb.setName(eventUpdateDTO.name());
        eventInDb.setDate(eventUpdateDTO.date());
        eventInDb.setStartTime(eventUpdateDTO.startTime());
        eventInDb.setEndTime(eventUpdateDTO.endTime());
        eventInDb.setVenue(eventUpdateDTO.venue());
        eventRepo.save(eventInDb);
        return toEventResponseDTO(eventInDb);
    }
}
