package com.manueljenni.api.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Point {

  @Id
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
