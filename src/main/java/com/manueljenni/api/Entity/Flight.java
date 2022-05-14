package com.manueljenni.api.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

  @Id
  private Long id;

  private String origin;

  private String origin_airport;

  private String destination;

  private String destination_airport;

  private String airline;

  private Long distance;

  private Long duration;

  private Boolean active;
}
