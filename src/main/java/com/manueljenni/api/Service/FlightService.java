package com.manueljenni.api.Service;

import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Response.*;
import com.manueljenni.api.Result.FlightResult;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.manueljenni.api.Result.RouteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("flightService")
public class FlightService {

  @Autowired
  FlightRepo flightRepo;

  public List<FlightResponse> getAllFlights() {
    List<FlightResult> flights = flightRepo.findAllFlights();

    return flights.stream()
            .map(flightResult -> {
              FlightResponse flightResponse = FlightResponse
                .builder()
                .departure(PlaceResponse.builder()
                  .type(1)
                  .iata(flightResult.getDepartureIata())
                  .name(flightResult.getDepartureName())
                  .city(flightResult.getDepartureCity())
                  .countryCode(flightResult.getDepartureCountryCode())
                  .countryName(flightResult.getDepartureCountryName())
                  .latitude(flightResult.getDepartureLatitude())
                  .longitude(flightResult.getArrivalLongitude())
                  .build())
                .arrival(PlaceResponse.builder()
                        .type(1)
                        .iata(flightResult.getArrivalIata())
                        .name(flightResult.getArrivalName())
                        .city(flightResult.getArrivalCity())
                        .countryCode(flightResult.getArrivalCountryCode())
                        .countryName(flightResult.getArrivalCountryName())
                        .latitude(flightResult.getArrivalLatitude())
                        .longitude(flightResult.getArrivalLongitude())
                        .build())
                      .airline(AirlineResponse.builder()
                        .code(flightResult.getAirlineCode())
                        .name(flightResult.getAirlineName())
                        .build())
                .departureTime(flightResult.getDepartureTime())
                .arrivalTime(flightResult.getArrivalTime())
                .flightNumber(flightResult.getFlightNumber())
                .miles(flightResult.getMiles())
                .duration(flightResult.getDuration())
                .milewaysUrl(flightResult.getMilewaysUrl())
                .build();

              return flightResponse;
            })
            .collect(Collectors.toList());
  }

  public List<FlightResponse> getAllPastFlights() {
    List<FlightResult> flights = flightRepo.findAllPastFlights();

    return flights.stream()
        .map(flightResult -> {
          FlightResponse flightResponse = FlightResponse
              .builder()
              .departure(PlaceResponse.builder()
                  .type(1)
                  .iata(flightResult.getDepartureIata())
                  .name(flightResult.getDepartureName())
                  .city(flightResult.getDepartureCity())
                  .countryCode(flightResult.getDepartureCountryCode())
                  .countryName(flightResult.getDepartureCountryName())
                  .latitude(flightResult.getDepartureLatitude())
                  .longitude(flightResult.getArrivalLongitude())
                  .build())
              .arrival(PlaceResponse.builder()
                  .type(1)
                  .iata(flightResult.getArrivalIata())
                  .name(flightResult.getArrivalName())
                  .city(flightResult.getArrivalCity())
                  .countryCode(flightResult.getArrivalCountryCode())
                  .countryName(flightResult.getArrivalCountryName())
                  .latitude(flightResult.getDepartureLatitude())
                  .longitude(flightResult.getArrivalLongitude())
                  .build())
              .airline(AirlineResponse.builder()
                  .code(flightResult.getAirlineCode())
                  .name(flightResult.getAirlineName())
                  .build())
              .departureTime(flightResult.getDepartureTime())
              .arrivalTime(flightResult.getArrivalTime())
              .flightNumber(flightResult.getFlightNumber())
              .miles(flightResult.getMiles())
              .duration(flightResult.getDuration())
              .milewaysUrl(flightResult.getMilewaysUrl())
              .build();

          return flightResponse;
        })
        .collect(Collectors.toList());
  }

  public List<FlightResponse> getAllUpcomingFlights() {
    List<FlightResult> flights = flightRepo.findAllUpcomingFlights();

    return flights.stream()
        .map(flightResult -> {
          FlightResponse flightResponse = FlightResponse
              .builder()
              .departure(PlaceResponse.builder()
                  .type(1)
                  .iata(flightResult.getDepartureIata())
                  .name(flightResult.getDepartureName())
                  .city(flightResult.getDepartureCity())
                  .countryCode(flightResult.getDepartureCountryCode())
                  .countryName(flightResult.getDepartureCountryName())
                  .latitude(flightResult.getDepartureLatitude())
                  .longitude(flightResult.getDepartureLongitude())
                  .build())
              .arrival(PlaceResponse.builder()
                  .type(1)
                  .iata(flightResult.getArrivalIata())
                  .name(flightResult.getArrivalName())
                  .city(flightResult.getArrivalCity())
                  .countryCode(flightResult.getArrivalCountryCode())
                  .countryName(flightResult.getArrivalCountryName())
                  .latitude(flightResult.getArrivalLatitude())
                  .longitude(flightResult.getArrivalLongitude())
                  .build())
              .airline(AirlineResponse.builder()
                  .code(flightResult.getAirlineCode())
                  .name(flightResult.getAirlineName())
                  .build())
              .departureTime(flightResult.getDepartureTime())
              .arrivalTime(flightResult.getArrivalTime())
              .flightNumber(flightResult.getFlightNumber())
              .miles(flightResult.getMiles())
              .duration(flightResult.getDuration())
              .milewaysUrl(flightResult.getMilewaysUrl())
              .build();

          return flightResponse;
        })
        .collect(Collectors.toList());
  }

  public List<RouteResponse> getUpcomingRoutes() {
      List<RouteResult> routes = flightRepo.findUpcomingRoutes();

      return routes.stream()
          .map(routeResult -> {
            RouteResponse routeResponse = RouteResponse.builder()
                .departureIata(routeResult.getDepartureIata())
                .arrivalIata(routeResult.getArrivalIata())
                .departureLatitude(routeResult.getDepartureLatitude())
                .departureLongitude(routeResult.getDepartureLongitude())
                .arrivalLatitude(routeResult.getArrivalLatitude())
                .arrivalLongitude(routeResult.getArrivalLongitude())
                .build();
        return routeResponse;
      })
      .collect(Collectors.toList());
  }

    public List<RouteResponse> getPastRoutes() {
        List<RouteResult> routes = flightRepo.findPastRoutes();

        return routes.stream()
                .map(routeResult -> {
                    RouteResponse routeResponse = RouteResponse.builder()
                            .departureIata(routeResult.getDepartureIata())
                            .arrivalIata(routeResult.getArrivalIata())
                            .departureLatitude(routeResult.getDepartureLatitude())
                            .departureLongitude(routeResult.getDepartureLongitude())
                            .arrivalLatitude(routeResult.getArrivalLatitude())
                            .arrivalLongitude(routeResult.getArrivalLongitude())
                            .build();
                    return routeResponse;
                })
                .collect(Collectors.toList());
    }

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
 */
}
