package com.masterticket.platform.ticketmanagementsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.masterticket.platform.ticketmanagementsystem.Repo.EventRepo;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;

@SpringBootApplication
public class TicketManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private EventRepo eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Event> events = new ArrayList<>();

        // Creating sample events
        Event event1 = new Event("Event 1", LocalDate.of(2024, 3, 23), LocalTime.of(10, 0), LocalTime.of(12, 0), "Venue 1", false);
        Event event2 = new Event("Event 2", LocalDate.of(2024, 3, 24), LocalTime.of(14, 0), LocalTime.of(16, 0), "Venue 2", true);
        events.add(event1);
        events.add(event2);

        // Save the list of events to the repository
        eventRepository.saveAll(events);
    }
}

