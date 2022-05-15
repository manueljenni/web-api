package com.manueljenni.api.Entity;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String origin;

  private String origin_airport;

  private String destination;

  private String destination_airport;

  private String airline;

  private Long distance;

  private Long duration;

  private Boolean active;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;
}
