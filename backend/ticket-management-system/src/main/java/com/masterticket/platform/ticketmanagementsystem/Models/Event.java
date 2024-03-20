package com.masterticket.platform.ticketmanagementsystem.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NoArgsConstructor
@Table(name="event")
public class Event {
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer eventID;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    private LocalTime startTime;

    @Getter @Setter
    private LocalTime endTime;

    @Getter @Setter
    private String venue;

    @Getter @Setter
    private boolean isCancelled;
    
    @Getter @Setter
    @OneToMany(
        mappedBy = "event"
    )
    @JsonManagedReference
    private List<Booking> bookings;

    @Getter @Setter
    @OneToMany(
        mappedBy = "event"
    )
    @JsonManagedReference
    private List<EventCategory> eventCategories;

    @OneToMany(
        mappedBy = "event"
    )
    @JsonManagedReference
    private Set<TicketingOfficer> ticketingOfficers;

    public Event(String name, LocalDate date, LocalTime startTime, LocalTime endTime, String venue, boolean isCancelled){
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.isCancelled = isCancelled;
    }
}
