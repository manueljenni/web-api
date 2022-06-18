package com.manueljenni.api.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private Long departure_id;

  private Long arrival_id;

  private Long airline_id;

  private ZonedDateTime departure_time;

  private ZonedDateTime arrival_time;

  private Long miles;

  private Long duration;

  private String mileways_url;

  private Boolean active;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;
}
