package com.masterticket.platform.ticketmanagementsystem.Repo.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.User.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
