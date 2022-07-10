package com.manueljenni.api.Response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripRequest {

  private String name;
  private Date start_date;
  private Date end_date;
}
