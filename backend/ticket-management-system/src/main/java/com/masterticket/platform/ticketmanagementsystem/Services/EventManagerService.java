package com.masterticket.platform.ticketmanagementsystem.Services;

import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.TicketingOfficer;
import com.masterticket.platform.ticketmanagementsystem.Repo.TicketingOfficerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventManagerService {

    private final TicketingOfficerRepo ticketingOfficerRepo;

    public AuthResponse createTicketingOfficer(String username,String password, Event event) {
        if (ticketingOfficerRepo.findByUsername(username).isPresent()) {
            return new AuthResponse("User already exists!", false);
        }
        TicketingOfficer to = new TicketingOfficer(username, password, 'T', event);
        ticketingOfficerRepo.save(to);
        return new AuthResponse("User has been created!", true);
    }
}
