package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketSearch implements Comparable<TicketSearch> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime; //in minutes

    @Override
    public int compareTo(TicketSearch o) {
        return price - o.price;
    }

    public boolean matches(String from, String to) {
        return departureAirport.equalsIgnoreCase(from) && arrivalAirport.equalsIgnoreCase(to);
    }
}
