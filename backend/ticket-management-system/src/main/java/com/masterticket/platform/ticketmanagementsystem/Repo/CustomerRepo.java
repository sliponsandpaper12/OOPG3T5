package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customer WHERE email = ?1", nativeQuery = true)
    Optional<Customer> findByEmail(String email);
}
