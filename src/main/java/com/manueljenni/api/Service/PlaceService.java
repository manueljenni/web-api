package com.manueljenni.api.Service;

import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Repo.PlaceRepo;
import com.manueljenni.api.Response.AirlineResponse;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Response.PlaceResponse;
import com.manueljenni.api.Response.RouteResponse;
import com.manueljenni.api.Result.FlightResult;
import com.manueljenni.api.Result.PlaceResult;
import com.manueljenni.api.Result.RouteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("placeService")
public class PlaceService {

  @Autowired
  PlaceRepo placeRepo;

  public List<PlaceResponse> getAllPlacesUnique() {
      List<PlaceResult> places = placeRepo.findAllPlacesUnique();

      return places.stream()
          .map(placeResult -> {
              return PlaceResponse.builder()
                .type(placeResult.getType())
                      .iata(placeResult.getIata())
                      .name(placeResult.getName())
                      .city(placeResult.getCity())
                      .countryCode(placeResult.getCountryCode())
                      .countryName(placeResult.getCountryName())
                      .latitude(placeResult.getLatitude())
                      .longitude(placeResult.getLongitude())
                      .build();
          })
          .collect(Collectors.toList());
  }
}
