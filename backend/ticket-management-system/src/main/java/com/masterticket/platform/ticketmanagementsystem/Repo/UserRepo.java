package com.masterticket.platform.ticketmanagementsystem.Repo;

import com.masterticket.platform.ticketmanagementsystem.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masterticket.platform.ticketmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    Optional<User> findByUsernameAndPassword(String username, String password);
}
