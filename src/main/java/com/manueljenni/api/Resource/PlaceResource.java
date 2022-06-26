package com.manueljenni.api.Resource;

import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Response.PlaceResponse;
import com.manueljenni.api.Response.RouteResponse;
import com.manueljenni.api.Service.FlightService;
import com.manueljenni.api.Service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/places")
public class PlaceResource {

  @Autowired
  PlaceService placeService;

  @GetMapping("/getAllPlacesUnique")
  public List<PlaceResponse> allPlacesUnique() {
    List<PlaceResponse> places =  placeService.getAllPlacesUnique();
    return places;
  }
}
