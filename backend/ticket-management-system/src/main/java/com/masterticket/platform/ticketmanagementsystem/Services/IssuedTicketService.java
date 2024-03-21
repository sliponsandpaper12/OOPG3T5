package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Repo.IssuedTicketRepo;

import lombok.AllArgsConstructor;

import java.util.*;

import com.masterticket.platform.ticketmanagementsystem.Models.IssuedTicket;

@Service
@AllArgsConstructor
public class IssuedTicketService {
    
    private final IssuedTicketRepo issuedTicketRepo;
    
    public double getTotalPrice(List<IssuedTicket> tickets){
        double amt = 0.0;
        for (IssuedTicket ticket: tickets){
            amt += ticket.getPrice();
        }
        return amt;
    }
}
