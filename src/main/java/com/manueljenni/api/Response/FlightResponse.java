package com.manueljenni.api.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

  private String origin;

  String originAirport;

  String destination;

  String destinationAirport;

  String airline;

  Long distance;

  Long duration;

  Boolean active;
}
