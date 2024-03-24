package com.masterticket.platform.ticketmanagementsystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.masterticket.platform.ticketmanagementsystem.Models.Event;
import com.masterticket.platform.ticketmanagementsystem.Models.User;
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

        public User getUserById(Integer userId){
        return userRepo.getReferenceById(userId);
    }
}
