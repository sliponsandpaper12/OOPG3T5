package com.masterticket.platform.ticketmanagementsystem.Models.Booking;

import jakarta.persistence.*;
import com.masterticket.platform.ticketmanagementsystem.Models.Events.EventCategory;

@Entity
public class IssuedTicket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    @ManyToOne
    @JoinColumn(name = "bookingID", nullable = false)
    private Booking booking;

    @OneToOne()
    @JoinColumn(name= "eventCategoryID")
    private EventCategory eventCategory;

}
