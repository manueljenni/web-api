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

  String origin_airport;

  String destination;

  String destination_airport;

  String airline;

  Long distance;

  Long duration;

  Boolean active;
}
