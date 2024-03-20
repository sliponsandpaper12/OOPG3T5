package com.masterticket.platform.ticketmanagementsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    
    @Getter @Setter
    private String email;

    @Getter @Setter
    private double balance;

}
