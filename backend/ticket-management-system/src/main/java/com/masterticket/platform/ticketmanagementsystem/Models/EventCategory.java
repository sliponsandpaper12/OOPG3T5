package com.masterticket.platform.ticketmanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@NoArgsConstructor
@Table(name="eventcategory")
public class EventCategory {
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer eventCategoryID;

    @Getter @Setter
    private char category;

    @Getter @Setter
    private double price;

    @Getter @Setter
    private int totalNumTickets;

    @Getter @Setter
    private int totalNumTicketsSold;

    @Getter @Setter
    private double cancellationFee;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name= "eventID"
    )
    @JsonBackReference
    private Event event;

    @Getter @Setter
    @OneToMany(
        mappedBy = "eventCategory"
    )
    @JsonManagedReference
    private List<IssuedTicket> issuedTickets;
    

    public EventCategory(char category, double price, int totalNumTickets, int totalNumTicketsSold, double cancellationFee){
        this.category = category;
        this.price = price;
        this.totalNumTickets = totalNumTickets;
        this.totalNumTicketsSold = totalNumTicketsSold;
        this.cancellationFee = cancellationFee;
    }

}
