package com.masterticket.platform.ticketmanagementsystem.Models.User;
import jakarta.persistence.*;

@Entity
public class BankAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankAccountID;

    @Column
    private String accountNumber;

    @Column
    private String hashedPassword;

    @Column 
    private double balance;

}
