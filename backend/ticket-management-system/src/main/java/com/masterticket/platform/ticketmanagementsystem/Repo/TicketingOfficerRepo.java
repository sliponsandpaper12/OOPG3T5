package com.masterticket.platform.ticketmanagementsystem.Repo;

import com.masterticket.platform.ticketmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.TicketingOfficer;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TicketingOfficerRepo extends JpaRepository<TicketingOfficer, Integer> {
    @Query(value = "SELECT * FROM user WHERE username = ?1 ", nativeQuery = true)
    Optional<TicketingOfficer> findByUsername(String username);
}
