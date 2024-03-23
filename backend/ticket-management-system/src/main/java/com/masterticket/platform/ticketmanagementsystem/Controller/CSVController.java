package com.masterticket.platform.ticketmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import javax.servlet.http.HttpServletResponse;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.CSVWriter;

// import com.masterticket.platform.ticketmanagementsystem.Services.CSVService;
import com.masterticket.platform.ticketmanagementsystem.Services.EventService;
import com.masterticket.platform.ticketmanagementsystem.Models.Event;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class CSVController {

    @Autowired
    //private CSVService csvService;
    private EventService eventService;

    // Example endpoint to trigger CSV export
    @GetMapping("/csvexport")
    public void exportCSV(HttpServletResponse response) 
            throws Exception {
 
        //set file name and content type
        String filename = "Employee-data.csv";
 
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Event> writer = new StatefulBeanToCsvBuilder<Event>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(eventService.findAll());
 
    }
}

