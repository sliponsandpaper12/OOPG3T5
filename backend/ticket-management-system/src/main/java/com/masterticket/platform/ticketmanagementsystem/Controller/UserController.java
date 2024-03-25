package com.masterticket.platform.ticketmanagementsystem.Controller;

import com.masterticket.platform.ticketmanagementsystem.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

}
