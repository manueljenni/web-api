package com.manueljenni.api.Response;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirlineResponse {

  @NotNull
  private String code;

  @NotNull
  private String name;
}
