package com.manueljenni.api.Result;

public interface RouteResult {

  String getDepartureIata();
  String getArrivalIata();

  Float getDepartureLatitude();
  Float getArrivalLatitude();
  Float getDepartureLongitude();
  Float getArrivalLongitude();
}