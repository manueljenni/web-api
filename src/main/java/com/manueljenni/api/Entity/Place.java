package com.manueljenni.api.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private Integer type;

    private String iata;

    private String name;

    private String city;

    private String country_name;

    private String country_code;

    private Float latitude;

    private Float longitude;

    private Boolean active;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
