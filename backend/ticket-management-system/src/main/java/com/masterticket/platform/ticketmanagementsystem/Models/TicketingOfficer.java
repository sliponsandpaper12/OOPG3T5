package com.masterticket.platform.ticketmanagementsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ticketingofficer")
@NoArgsConstructor
@AllArgsConstructor
public class TicketingOfficer extends User{

    @Getter @Setter
    @ManyToOne
    @JoinColumn(
        name= "eventID"
    )
    @JsonBackReference
    private Event event;

}
