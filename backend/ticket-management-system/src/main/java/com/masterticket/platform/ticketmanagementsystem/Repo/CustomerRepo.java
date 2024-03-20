package com.masterticket.platform.ticketmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
