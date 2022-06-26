package com.manueljenni.api.Response;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
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
public class RouteResponse {

  @NotNull
  private String departureIata;

  @NotNull
  private String arrivalIata;

  @NotNull
  private Float departureLatitude;

  @NotNull
  private Float departureLongitude;

  @NotNull
  private Float arrivalLatitude;

  @NotNull
  private Float arrivalLongitude;
}
