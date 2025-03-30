package com.example.flights.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Route {
    private List<String> route;
    private double totalPrice;
}
