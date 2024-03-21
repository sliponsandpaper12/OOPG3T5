package com.masterticket.platform.ticketmanagementsystem.Models.DTO;

import java.util.*;

public record EventStatisticsResponseDTO(
    Map<Character, Map<String, Double>> eventStatistics
) {
    
}
