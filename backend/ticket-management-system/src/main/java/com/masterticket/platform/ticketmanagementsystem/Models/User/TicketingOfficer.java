package com.masterticket.platform.ticketmanagementsystem.Models.User;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class TicketingOfficer extends User{
    
    @Column
    private List<Integer> eventID;
    
}
