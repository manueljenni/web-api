package com.manueljenni.api.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manueljenni.api.Entity.Airline;
import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Entity.Place;
import com.manueljenni.api.Repo.AirlineRepo;
import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Repo.PlaceRepo;
import com.manueljenni.api.Result.AirlineResult;
import com.manueljenni.api.Result.PlaceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Qualifier("articleService")
public class MilewaysService {

  @Autowired
  PlaceRepo placeRepo;

  @Autowired
  FlightRepo flightRepo;

  @Autowired
  AirlineRepo airlineRepo;

  final String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxOTg0IiwiaWF0IjoxNjU0OTc5NTA2LCJleHAiOjQ4MTA2NTMxMDZ9.TvgmJiTAIJa9clmuxxtQ2ny4yRuVCVhh9o8twzSxIdDYUsJ5C0w-j5Enqi_sFFPbWY-bVIpZC534dV5lBm4Hvg";

  public String updateAllFlights() {

    // Delete flight repo
    flightRepo.deleteAll();

    final String url = "https://prod.mileways-flieger.xyz:443/api/v1/trips";

    // Set headers
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + accessToken);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity entity = new HttpEntity(headers);

    // Rest-template
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

    // Gson
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    JsonObject apiResponse = gson.fromJson((String) responseEntity.getBody(), JsonObject.class);
    JsonArray trips = apiResponse.getAsJsonArray("results");

    AtomicInteger addedFlightsCount = new AtomicInteger();
    trips.forEach(e -> {

      JsonArray trip = e.getAsJsonObject().get("flights").getAsJsonArray();
      JsonObject flight = trip.get(0).getAsJsonObject();

      // Check if airport exists
      // Yes -> don't save
      // No -> save

      JsonObject departureAirport = flight.get("departure").getAsJsonObject();
      PlaceResult departureAirportResult = placeRepo.getAirportIdByIata(departureAirport.get("iata").getAsString());
      Long departureAirportId;
      if (departureAirportResult != null) {
        departureAirportId = departureAirportResult.getId();
      } else {
        // Save new airport
        placeRepo.save(Place.builder()
                .type(1)
                .iata(departureAirport.get("iata").getAsString())
                .name(departureAirport.get("name").getAsString())
                .city(departureAirport.get("city").getAsString())
                .country_name(departureAirport.get("countryName").getAsString())
                .country_code(departureAirport.get("countryCode").getAsString())
                .latitude(departureAirport.get("latitude").getAsFloat())
                .longitude(departureAirport.get("longitude").getAsFloat())
                .timeZoneName(departureAirport.get("timeZoneRegionName").getAsString())
                .active(true)
                .build());

        departureAirportId = placeRepo.getAirportIdByIata(departureAirport.get("iata").getAsString()).getId();
      }

      JsonObject arrivalAirport = flight.get("arrival").getAsJsonObject();
      PlaceResult arrivalAirportResult = placeRepo.getAirportIdByIata(arrivalAirport.get("iata").getAsString());
      Long arrivalAirportId;
      if (arrivalAirportResult != null) {
        arrivalAirportId = arrivalAirportResult.getId();
      } else {
        // Save new airport
        placeRepo.save(Place.builder()
                .type(1)
                .iata(arrivalAirport.get("iata").getAsString())
                .name(arrivalAirport.get("name").getAsString())
                .city(arrivalAirport.get("city").getAsString())
                .country_name(arrivalAirport.get("countryName").getAsString())
                .country_code(arrivalAirport.get("countryCode").getAsString())
                .latitude(arrivalAirport.get("latitude").getAsFloat())
                .longitude(arrivalAirport.get("longitude").getAsFloat())
                .timeZoneName(arrivalAirport.get("timeZoneRegionName").getAsString())
                .active(true)
                .build());

        arrivalAirportId = placeRepo.getAirportIdByIata(arrivalAirport.get("iata").getAsString()).getId();
      }

      JsonObject airline = flight.get("airline").getAsJsonObject();
      AirlineResult airlineResult = airlineRepo.getAirlineByCode(airline.get("fs").getAsString());
      Long airlineId;
      if (airlineResult != null) {
        airlineId = airlineResult.getId();
      } else {
        airlineRepo.save(Airline.builder()
                .name(airline.get("name").getAsString())
                .code(airline.get("fs").getAsString())
                .build());

        airlineId = airlineRepo.getAirlineByCode(airline.get("fs").getAsString()).getId();
      }

      // Save flight
      flightRepo.save(Flight.builder()
              .departure_id(departureAirportId)
              .arrival_id(arrivalAirportId)
              .airline_id(airlineId)
              .departure_time(Instant.parse(flight.get("departureTime").getAsString())
                      .atZone(ZoneId.of(departureAirport.get("timeZoneRegionName").getAsString())))
              .arrival_time(Instant.parse(flight.get("arrivalTime").getAsString())
                      .atZone(ZoneId.of(arrivalAirport.get("timeZoneRegionName").getAsString())))
              .miles(flight.get("miles").getAsLong())
              .duration(flight.get("duration").getAsLong())
              .mileways_url(flight.get("shareUrl").getAsString())
              .active(true)
              .build());
      addedFlightsCount.getAndIncrement();
    });

    return "Added " + addedFlightsCount + " flights.";
  }
}
