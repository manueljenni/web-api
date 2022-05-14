package com.manueljenni.api.Result;

public interface FlightResult {

  String getOrigin();

  String getOriginAirport();

  String getDestination();

  String getDestinationAirport();

  String getAirline();

  Long getDistance();

  Long getDuration();

  Boolean getActive();


}