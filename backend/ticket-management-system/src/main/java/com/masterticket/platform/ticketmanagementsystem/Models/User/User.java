package com.masterticket.platform.ticketmanagementsystem.Models.User;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    @Column
    private String username;

    @Column
    private String hashedPassword;

    @Column 
    private char accType;

 
}
