package com.example.flights.service;

import com.example.flights.model.FlightPossibilities;
import com.example.flights.model.Route;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {

    private final Map<String, List<Flight>> flightMap = new HashMap<>();

    public FlightService() {
        //Must change the number i between [1,5]
        //Restart the application
        //Run the http example i
        enableExample(4);
    }

    private void enableExample(int number) {
        switch (number) {
            case 1:
                addFlight("SOF", "IST", 10);
                addFlight("IST", "CMB", 20);
                addFlight("CMB", "MLE", 40);
                break;

            //cases are similar
            case 2:
            case 4:
            case 5:
                addFlight("SOF", "MLE", 70);
                addFlight("SOF", "LON", 10);
                addFlight("LON", "MLE", 20);
                break;

            case 3:
                addFlight("SOF", "LON", 10);
                addFlight("SOF", "NYC", 20);
                break;
        }
    }

    private static class Flight {
        String to;
        int price;

        Flight(String to, int price) {
            this.to = to;
            this.price = price;
        }
    }

    private void addFlight(String from, String to, int price) {
        flightMap.putIfAbsent(from, new ArrayList<>());
        flightMap.get(from).add(new Flight(to, price));
    }

    private void mergeSort(List<Route> routes) {
        if (routes.size() <= 1)
            return;

        int mid = routes.size() / 2;

        List<Route> left = new ArrayList<>(routes.subList(0, mid));
        List<Route> right = new ArrayList<>(routes.subList(mid, routes.size()));

        mergeSort(left);
        mergeSort(right);

        merge(routes, left, right);
    }

    private void merge(List<Route> routes, List<Route> left, List<Route> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTotalPrice() <= right.get(j).getTotalPrice())
                routes.set(k++, left.get(i++));

            else
                routes.set(k++, right.get(j++));
        }

        while (i < left.size())
            routes.set(k++, left.get(i++));

        while (j < right.size())
            routes.set(k++, right.get(j++));
    }

    private void dfs(String current, String destination, List<String> path, int cost,
                     List<Route> results, Set<String> visited, Integer maxTransfers) {

        if (visited.contains(current)) return;

        path.add(current);
        visited.add(current);

        if (maxTransfers != null && path.size() - 1 > maxTransfers) {
            path.removeLast();
            visited.remove(current);
            return;
        }

        if (current.equals(destination))
            results.add(new Route(new ArrayList<>(path), cost));

        else if (flightMap.containsKey(current)) {
            for (Flight f : flightMap.get(current))
                dfs(f.to, destination, path, cost + f.price, results, visited, maxTransfers);
        }

        path.removeLast();
        visited.remove(current);
    }

    public List<FlightPossibilities> findRoutes(String origin, String destination, Integer maxTransfers) {
        List<Route> results = new ArrayList<>();
        dfs(origin, destination, new ArrayList<>(), 0, results, new HashSet<>(), maxTransfers);

        mergeSort(results);

        List<FlightPossibilities> response = new ArrayList<>();
        for (Route r : results)
            response.add(new FlightPossibilities(r.getRoute(), r.getTotalPrice()));

        return response;
    }
}
