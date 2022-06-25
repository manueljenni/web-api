package com.manueljenni.api.Resource;

import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Service.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/flights")
public class FlightResource {

  @Autowired
  FlightService flightService;

  @GetMapping("/getAllFlights")
  public List<FlightResponse> allFlights() {
    List<FlightResponse> flights =  flightService.getAllFlights();
    return flights;
  }

  @GetMapping("/getAllPastFlights")
  public List<FlightResponse> allPastFlights() {
    List<FlightResponse> flights =  flightService.getAllPastFlights();
    return flights;
  }

  @GetMapping("/getAllUpcomingFlights")
  public List<FlightResponse> allUpcomingFlights() {
    List<FlightResponse> flights =  flightService.getAllUpcomingFlights();
    return flights;
  }

  /*
  @GetMapping("/getFlightById")
  public FlightResponse flightById(Long id) {
    FlightResponse flight =  flightService.getFlightById(id);
    return flight;
  }

  @GetMapping("/getFlightsByRoute")
  public List<FlightResponse> flightsByRoute(String departure_iata, String arrival_iata) {
    List<FlightResponse> flights = flightService.getFlightsByRoute(departure_iata, arrival_iata);
    return flights;
  }

  @PostMapping("/addFlight")
  public void addArticle(
      @RequestBody FlightRequest flight
  ) {
    flightService.saveFlight(flight);
    System.out.println("Flight saved!");
  }

   */
}
