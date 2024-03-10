package com.masterticket.platform.ticketmanagementsystem.Repo.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.User.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount, Long> {
    
}
