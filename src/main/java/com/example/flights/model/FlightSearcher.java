package com.example.flights.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightSearcher {
    private String departurePlace;
    private String arrivalPlace;
    private Integer maxTransfers;
}
