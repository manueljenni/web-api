package com.manueljenni.api.Service;

import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

  @Autowired
  FlightRepo flightRepo;

  public List<FlightResponse> getAllFlights() {
      List<FlightResult> flights = flightRepo.findAllFlights();

      return flights.stream()
          .map(flightsResult -> {
            FlightResponse flightResponse = FlightResponse
                .builder()
                .origin(flightsResult.getOrigin())
                .originAirport(flightsResult.getOriginAirport())
                .destination(flightsResult.getDestination())
                .destinationAirport(flightsResult.getDestinationAirport())
                .airline(flightsResult.getAirline())
                .distance(flightsResult.getDistance())
                .duration(flightsResult.getDuration())
                .active(flightsResult.getActive())
                .build();
            return flightResponse;
          })
          .collect(Collectors.toList());
  }

}
