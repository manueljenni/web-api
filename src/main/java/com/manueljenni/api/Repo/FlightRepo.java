package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

  @Query(value = """
      SELECT *
      FROM flight
      """,
      nativeQuery = true
  )
  List<FlightResult> findAllFlights();
}
