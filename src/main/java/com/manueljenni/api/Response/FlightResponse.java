package com.manueljenni.api.Response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

  @NotNull
  private PlaceResponse departure;

  @NotNull
  private PlaceResponse arrival;

  @Nullable
  private ZonedDateTime departureTime;

  @Nullable
  private ZonedDateTime arrivalTime;

  @Nullable
  private AirlineResponse airline;

  @Nullable
  private Long miles;

  @Nullable
  private Long duration;

  @Nullable
  private String milewaysUrl;
}
