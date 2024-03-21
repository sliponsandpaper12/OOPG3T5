package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;
import com.masterticket.platform.ticketmanagementsystem.Repo.CustomerRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    
    private final CustomerRepo customerRepo;

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
}
