package com.manueljenni.api.Service;

import com.manueljenni.api.Entity.Trip;
import com.manueljenni.api.Repo.TripRepo;
import com.manueljenni.api.Response.TripRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@Qualifier("tripService")
public class TripService {

  @Autowired
  TripRepo tripRepo;

  public void saveTrip(TripRequest tripRequest) {
    Trip saveTrip = Trip.builder()
            .name(tripRequest.getName())
            .start_date(tripRequest.getStart_date())
            .end_date(tripRequest.getEnd_date())
            .build();

    tripRepo.save(saveTrip);
  }
}
