package com.manueljenni.api.Result;

import java.time.ZonedDateTime;

public interface FlightResult {

  Long getId();

  String getDepartureIata();
  String getDepartureName();
  String getDepartureCity();
  String getDepartureCountryCode();
  String getDepartureCountryName();
  Float getDepartureLatitude();
  String getDepartureLongitude();

  String getArrivalIata();
  String getArrivalName();
  String getArrivalCity();
  String getArrivalCountryCode();
  String getArrivalCountryName();
  String getArrivalLatitude();
  Float getArrivalLongitude();

  String getAirlineCode();
  String getAirlineName();

  String getDepartureTime();
  String getArrivalTime();

  Long getMiles();
  Long getDuration();

  String getMilewaysUrl();
}