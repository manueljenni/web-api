package com.manueljenni.api.Result;

import java.time.LocalDateTime;

public interface FlightResult {

  Long getId();
  Long getFlightNumber();

  String getDepartureIata();
  String getDepartureName();
  String getDepartureCity();
  String getDepartureCountryCode();
  String getDepartureCountryName();
  Float getDepartureLatitude();
  Float getDepartureLongitude();

  String getArrivalIata();
  String getArrivalName();
  String getArrivalCity();
  String getArrivalCountryCode();
  String getArrivalCountryName();
  Float getArrivalLatitude();
  Float getArrivalLongitude();

  String getAirlineCode();
  String getAirlineName();

  LocalDateTime getDepartureTime();
  LocalDateTime getArrivalTime();

  Long getMiles();
  Long getDuration();

  String getMilewaysUrl();
}