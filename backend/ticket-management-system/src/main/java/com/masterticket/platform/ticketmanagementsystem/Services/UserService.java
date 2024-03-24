package com.masterticket.platform.ticketmanagementsystem.Services;

import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Repo.UserRepo;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final CustomerService customerService;

    public boolean refundUser(Integer userID, double amount){
        var userInDb = userRepo.getReferenceById(userID);
        if (userInDb.getType() == 'C'){
            return customerService.refundCustomer(userID, amount);
        }else{
            return false;
        }
    }

    public AuthResponse login(LoginRequest loginRequest) {
        if (userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()).isPresent()) {
            return new AuthResponse("Login successful!", true);
        }
        return new AuthResponse("Username or password is incorrect.", false);
    }
}
