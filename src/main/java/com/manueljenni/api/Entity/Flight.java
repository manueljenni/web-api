package com.manueljenni.api.Entity;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String origin;

  private String originAirport;

  private String destination;

  private String destinationAirport;

  private String airline;

  private Long distance;

  private Long duration;

  private Boolean active;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;
}
