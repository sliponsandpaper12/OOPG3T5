package com.masterticket.platform.ticketmanagementsystem.Models.Events;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;

    @Column
    private String name;
    
    @Column 
    private LocalDate date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private String venue;

    @Column
    private boolean isCancelled;

    @OneToMany(mappedBy = "event")
    private List<EventCategory> eventCategories;

}
