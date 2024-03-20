package com.masterticket.platform.ticketmanagementsystem.Controller;

import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventUpdateDTO;
import com.masterticket.platform.ticketmanagementsystem.Services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService eventService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDTO createEvent(
        @RequestBody EventDTO eventDTO){
            return eventService.createEvent(eventDTO);
    } 

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDTO updateEvent(
        @RequestBody EventUpdateDTO eventUpdateDTO){
            return eventService.updateEvent(eventUpdateDTO);
        }

}
