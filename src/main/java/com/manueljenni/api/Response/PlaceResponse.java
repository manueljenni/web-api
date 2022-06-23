package com.manueljenni.api.Response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponse {

  Integer type;

  String iata;

  String name;

  String city;

  String countryCode;

  String countryName;

  Float latitude;

  Float longitude;
}
