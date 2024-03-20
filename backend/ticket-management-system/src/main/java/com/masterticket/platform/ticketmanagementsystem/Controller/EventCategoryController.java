package com.masterticket.platform.ticketmanagementsystem.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.masterticket.platform.ticketmanagementsystem.Services.EventCategoryService;
import lombok.AllArgsConstructor;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryResponseDTO;
import com.masterticket.platform.ticketmanagementsystem.Models.DTO.EventCategoryUpdateDTO;


@RestController
@RequestMapping("/eventcategory")
@CrossOrigin
@AllArgsConstructor
public class EventCategoryController {
    
    private final EventCategoryService eventCategoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EventCategoryResponseDTO createEventCategory(
        @RequestBody EventCategoryDTO eventCategoryDTO){
            return eventCategoryService.createEventCategory(eventCategoryDTO);
        }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public EventCategoryResponseDTO updateEventCategory(
        @RequestBody EventCategoryUpdateDTO eventCategoryUpdateDTO){
            return eventCategoryService.updateEventCategory(eventCategoryUpdateDTO);
        }
    
}
