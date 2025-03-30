package com.example.flights.controller;

import com.example.flights.model.FlightSearcher;
import com.example.flights.model.FlightPossibilities;
import com.example.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public List<FlightPossibilities> getRoutes(@RequestBody FlightSearcher request) {
        return flightService.findRoutes(request.getDeparturePlace(), request.getArrivalPlace(), request.getMaxTransfers());
    }
}
