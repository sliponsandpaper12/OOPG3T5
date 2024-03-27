package com.masterticket.platform.ticketmanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
