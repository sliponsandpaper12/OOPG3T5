package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class CSVService {

    public void exportDataToCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            // Write data to CSV file
            // Example:
            String[] headers = {"Column 1", "Column 2"};
            String[] dataRow1 = {"Data 1", "Data 2"};
            String[] dataRow2 = {"Data 3", "Data 4"};

            writer.writeNext(headers);
            writer.writeNext(dataRow1);
            writer.writeNext(dataRow2);

            // Add more data rows if needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
