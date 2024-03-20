package com.masterticket.platform.ticketmanagementsystem.Controller;

import com.masterticket.platform.ticketmanagementsystem.Services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService eventService;
    
}
