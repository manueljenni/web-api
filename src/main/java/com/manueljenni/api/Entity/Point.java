package com.manueljenni.api.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Point {

  @Id
  @GeneratedValue
  private Long id;

  private Double latitude;

  private Double longitude;

  private String name;

  private String type;

  private String city;

  private String country_alpha2;

  private String country_alpha3;

  private Boolean active;
}
