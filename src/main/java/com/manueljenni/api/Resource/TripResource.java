package com.manueljenni.api.Resource;

import com.manueljenni.api.Response.ArticleRequest;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Response.RouteResponse;
import com.manueljenni.api.Response.TripRequest;
import com.manueljenni.api.Service.FlightService;
import com.manueljenni.api.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/flights")
public class TripResource {

  @Autowired
  TripService tripService;

  @PostMapping("/addTrip")
  public void addTrip(
          @RequestBody TripRequest trip
  ) {
    tripService.saveTrip(trip);
    System.out.println("Trip saved!");
  }
}
