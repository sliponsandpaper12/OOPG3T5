package com.masterticket.platform.ticketmanagementsystem.Controller;

import com.masterticket.platform.ticketmanagementsystem.Models.DTO.UserRequest;
import com.masterticket.platform.ticketmanagementsystem.Models.User;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.AuthResponse;
import com.masterticket.platform.ticketmanagementsystem.Services.CustomerService;
import com.masterticket.platform.ticketmanagementsystem.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse createUser(@RequestBody UserRequest userRequest) {
        return customerService.register(userRequest);
    }
}
