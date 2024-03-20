package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Repo.EventCategoryRepo;

import lombok.AllArgsConstructor;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryUpdateDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.EventCategory;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;

@Service
@AllArgsConstructor
public class EventCategoryService {
    
    private final EventCategoryRepo eventCategoryRepo;

    public EventCategory toEventCategory(EventCategoryDTO eventCategoryDTO){
        var eventCategory = new EventCategory();
        eventCategory.setCategory(eventCategoryDTO.category());
        eventCategory.setPrice(eventCategoryDTO.price());
        eventCategory.setTotalNumTickets(eventCategoryDTO.totalNumTickets());
        
        var event = new Event();
        event.setEventID(eventCategoryDTO.eventID());
        eventCategory.setEvent(event);
        
        return eventCategory;
    }

    public EventCategoryResponseDTO toEventCategoryResponseDTO(EventCategory eventCategory){
        return new EventCategoryResponseDTO(eventCategory.getEventCategoryID());
    }

    public EventCategoryResponseDTO createEventCategory(EventCategoryDTO eventCategoryDTO){
        var newEventCategory = eventCategoryRepo.save(toEventCategory(eventCategoryDTO));
        return toEventCategoryResponseDTO(newEventCategory);
    }

    public EventCategoryResponseDTO updateEventCategory(EventCategoryUpdateDTO eventCategoryUpdateDTO){
        var eventCategoryInDb = eventCategoryRepo.getReferenceById(eventCategoryUpdateDTO.eventCategoryID());
        eventCategoryInDb.setCategory(eventCategoryUpdateDTO.category());
        eventCategoryInDb.setPrice(eventCategoryUpdateDTO.price());
        eventCategoryInDb.setTotalNumTickets(eventCategoryUpdateDTO.totalNumTickets());
        eventCategoryRepo.save(eventCategoryInDb);
        return toEventCategoryResponseDTO(eventCategoryInDb);
    }
}
