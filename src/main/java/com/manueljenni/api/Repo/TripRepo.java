package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {

}
