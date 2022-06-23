package com.manueljenni.api.Result;


public interface PlaceResult {

  Long getId();

  Integer getType();

  String getIata();

  String getName();

  String getCity();

  String getCountryName();

  String getCountryCode();

  Float getLatitude();

  Float getLongitude();
}
