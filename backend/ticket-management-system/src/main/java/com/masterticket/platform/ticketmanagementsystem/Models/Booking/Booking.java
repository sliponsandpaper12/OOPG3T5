package com.masterticket.platform.ticketmanagementsystem.Models.Booking;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.masterticket.platform.ticketmanagementsystem.Models.Events.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.User.User;
import java.util.*;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;

    @Column
    private int numberOfTickets;

    @Column 
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @Column 
    private double amountPaid;

    @Column 
    private double totalCancellationFee;

    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;

    @OneToMany(mappedBy = "booking")
    private List<IssuedTicket> tickets;

}
