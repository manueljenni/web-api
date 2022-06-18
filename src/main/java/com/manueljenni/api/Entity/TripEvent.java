package com.manueljenni.api.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripEvent {

    @Id
    private Long trip_id;

    private Long event_id;
}
