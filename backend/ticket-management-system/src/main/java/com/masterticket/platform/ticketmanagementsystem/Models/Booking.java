package com.masterticket.platform.ticketmanagementsystem.Models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.*;

@Entity
@Table(name="booking")
@NoArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer bookingID;

    @Getter @Setter
    private LocalDateTime timestamp;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name = "eventID"
    )
    @JsonBackReference
    private Event event;

    @Getter @Setter
    @OneToMany(
        mappedBy = "booking"
    )
    @JsonManagedReference
    private List<IssuedTicket> tickets;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name= "userID"
    )
    @JsonBackReference
    private User user;

    @Getter @Setter
    private double amountPaid;

    @Getter @Setter
    private boolean isRefunded;

    public Booking(Event event, List<IssuedTicket> tickers, User user, double amountPaid, boolean isRefunded){
        this.timestamp = LocalDateTime.now();
        this.event = event;
        this.tickets = tickers;
        this.user = user;
        this.amountPaid = amountPaid;
        this.isRefunded = isRefunded;
    }
}
