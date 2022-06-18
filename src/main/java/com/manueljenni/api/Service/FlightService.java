package com.manueljenni.api.Service;

import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Response.FlightRequest;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("flightService")
public class FlightService {

  @Autowired
  FlightRepo flightRepo;
/*
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

  public FlightResponse getFlightById(Long id) {
    FlightResult flight = flightRepo.findFlightById(id);

      FlightResponse flightResponse = FlightResponse
        .builder()
        .origin(flight.getOrigin())
        .originAirport(flight.getOriginAirport())
        .destination(flight.getDestination())
        .destinationAirport(flight.getDestinationAirport())
        .airline(flight.getAirline())
        .distance(flight.getDistance())
        .duration(flight.getDuration())
        .active(flight.getActive())
        .build();

      return  flightResponse;
  }

  public List<FlightResponse> getFlightsByRoute(String origin_iata, String destination_iata) {
    List<FlightResult> flights = flightRepo.findFlightsByRoute(origin_iata, destination_iata);

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

  public void saveFlight(FlightRequest flight) {
    Flight saveFlight = Flight.builder()
        .origin(flight.getOrigin())
        .originAirport(flight.getOriginAirport())
        .destination(flight.getDestination())
        .destinationAirport(flight.getDestinationAirport())
        .airline(flight.getAirline())
        .distance(flight.getDistance())
        .duration(flight.getDuration())
        .active(flight.getActive())
        .build();
  }

 */
}
