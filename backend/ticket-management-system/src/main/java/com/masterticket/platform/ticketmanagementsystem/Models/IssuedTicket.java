package com.masterticket.platform.ticketmanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Table(name="issuedticket")
public class IssuedTicket {
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer ticketID;

    @Getter @Setter
    private double price;
    
    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name= "bookingID"
    )
    @JsonBackReference
    private Booking booking;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name= "eventCategoryID"
    )
    @JsonBackReference
    private EventCategory eventCategory;

    @Getter @Setter
    private boolean isValid;

    public IssuedTicket(boolean isValid){
        this.isValid = isValid;
    }
    


}
