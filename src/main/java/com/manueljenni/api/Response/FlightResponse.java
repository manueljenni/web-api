package com.manueljenni.api.Response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

  @Nullable
  private String origin;

  @NotNull
  private String originAirport;

  @Nullable
  private String destination;

  @NotNull
  private String destinationAirport;

  @Nullable
  private String airline;

  @Nullable
  private Long distance;

  @Nullable
  private Long duration;

  @Nullable
  private Boolean active;
}
