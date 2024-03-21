package com.masterticket.platform.ticketmanagementsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="user")
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer userID;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private char type;

    @Getter @Setter
        @OneToMany(
        mappedBy = "user"
    )
    @JsonManagedReference
    private List<Booking> bookings;
    
    public User(String username, String password, char type){
        this.username = username;
        this.password = password;
        this.type = type;
    }
}
