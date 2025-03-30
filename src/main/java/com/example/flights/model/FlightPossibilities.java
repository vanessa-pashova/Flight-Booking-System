package com.example.flights.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FlightPossibilities {
    @JsonProperty("cities")
    private List<String> route;
    private double price;
}
