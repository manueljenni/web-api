package com.manueljenni.api;

import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import com.manueljenni.api.Service.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainRestController {

  @Autowired
  FlightService flightService;

  @GetMapping("/hello")
  public List<FlightResponse> returnFlights() {
      List<FlightResponse> flights =  flightService.getAllFlights();
      return flights;
  }
}
