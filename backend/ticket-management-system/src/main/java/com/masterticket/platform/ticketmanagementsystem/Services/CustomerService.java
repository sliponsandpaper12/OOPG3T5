package com.masterticket.platform.ticketmanagementsystem.Services;

import com.masterticket.platform.ticketmanagementsystem.Models.Customer;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.UserRequest;
import com.masterticket.platform.ticketmanagementsystem.Models.User;
import com.masterticket.platform.ticketmanagementsystem.Repo.CustomerRepo;
import com.masterticket.platform.ticketmanagementsystem.Repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    
    private final CustomerRepo customerRepo;
    private final UserRepo userRepo;

    public boolean refundCustomer(Integer customerID, double amount){
        try{
            var customerInDb = customerRepo.getReferenceById(customerID); 
            customerInDb.setBalance(customerInDb.getBalance() + amount);
            customerRepo.save(customerInDb);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public AuthResponse register(UserRequest userRequest) {
        if (customerRepo.findByEmail(userRequest.getEmail()).isPresent()) {
            return new AuthResponse("User already exists!", false);
        }
        User u = new User(userRequest.getUsername(), userRequest.getPassword(), 'C');
        Customer c = new Customer(userRequest.getUsername(), userRequest.getPassword(), 'C', userRequest.getEmail(), 1000.0);
        userRepo.save(u);
        customerRepo.save(c);

        return new AuthResponse("User has been created!", true);
    }
}
