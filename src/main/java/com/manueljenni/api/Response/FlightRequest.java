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
public class FlightRequest {

  private String origin;
  private String originAirport;
  private String destination;
  private String destinationAirport;
  private String airline;
  private Long distance;
  private Long duration;
  private Boolean active = true;
}
