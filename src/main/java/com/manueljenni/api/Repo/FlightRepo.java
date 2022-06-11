package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

  @Query(value = "SELECT " +
      "      updated_at AS updatedAt," +
      "      id as id," +
      "      origin as origin," +
      "      origin_airport as originAirport," +
      "      destination as destination," +
      "      destination_airport as destinationAirport," +
      "      distance," +
      "      duration," +
      "      active," +
      "      airline " +
      "      FROM flight " +
      "      ORDER BY updated_at",
      nativeQuery = true
  )
  List<FlightResult> findAllFlights();

  @Query(value= "SELECT \n" +
      "      id,\n" +
      "      origin as origin,\n" +
      "      origin_airport as originAirport,\n" +
      "      destination as destination,\n" +
      "      destination_airport as destinationAirport,\n" +
      "      distance,\n" +
      "      duration,\n" +
      "      active,\n" +
      "      airline\n" +
      "      FROM flight\n" +
      "      WHERE id = ?1", nativeQuery= true)
  FlightResult findFlightById(Long id);

  @Query(value= "SELECT \n" +
      "      updated_at AS updatedAt,\n" +
      "      id as id,\n" +
      "      origin as origin,\n" +
      "      origin_airport as originAirport,\n" +
      "      destination as destination,\n" +
      "      destination_airport as destinationAirport,\n" +
      "      distance,\n" +
      "      duration,\n" +
      "      active,\n" +
      "      airline\n" +
      "      FROM flight\n" +
      "      WHERE origin_airport = ?1\n" +
      "        AND destination_airport = ?2\n" +
      "      ORDER BY updated_at", nativeQuery = true)
  List<FlightResult> findFlightsByRoute(String origin_iata, String destination_iata);
}
