package com.masterticket.platform.ticketmanagementsystem.Repo;

import com.masterticket.platform.ticketmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT *, 0 AS clazz_ FROM user WHERE username = ?1 AND password = ?2 LIMIT 1", nativeQuery = true)
    Optional<User> findOneByUsernameAndPassword(String username, String password);
}
