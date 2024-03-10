package com.masterticket.platform.ticketmanagementsystem.Models.User;
import jakarta.persistence.*;

@Entity
public class Customer extends User{
    
    @Column 
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "bankAccountID")
    private BankAccount bankAccount;
    
}
