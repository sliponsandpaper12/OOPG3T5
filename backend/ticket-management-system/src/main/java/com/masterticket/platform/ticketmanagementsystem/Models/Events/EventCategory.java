package com.masterticket.platform.ticketmanagementsystem.Models.Events;
import jakarta.persistence.*;

@Entity
public class EventCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventCategoryID;

    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;

    @Column
    private char category;

    @Column
    private double price;

    @Column
    private int totalNumTickets;

    @Column 
    private int totalNumTicketsSold;

    @Column 
    private double cancellationFee;
}
