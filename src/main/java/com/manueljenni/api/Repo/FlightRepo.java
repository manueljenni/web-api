package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Flight;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Result.FlightResult;
import com.manueljenni.api.Result.RouteResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

  @Query(value = "SELECT" +
      "    flight.id AS id," +
      "    flight.flight_number as flightNumber," +
      "    departure.iata AS departureIata," +
      "    departure.name AS departureName," +
      "    departure.city AS departureCity," +
      "    departure.country_code AS departureCountryCode," +
      "    departure.country_name AS departureCountryName," +
      "    departure.latitude AS departureLatitude," +
      "    departure.longitude AS departureLongitude," +
      "    arrival.iata AS arrivalIata," +
      "    arrival.name AS arrivalName," +
      "    arrival.city AS arrivalCity," +
      "    arrival.country_code AS arrivalCountryCode," +
      "    arrival.country_name AS arrivalCountryName," +
      "    arrival.latitude AS arrivalLatitude," +
      "    arrival.longitude AS arrivalLongitude," +
      "    airline.code AS airlineCode," +
      "    airline.name AS airlineName," +
      "    departure_time AT time zone 'utc' AT time zone departure.time_zone_name AS departureTime," +
      "    arrival_time AT time zone 'utc' AT time zone arrival.time_zone_name AS arrivalTime," +
      "    miles AS miles," +
      "    duration AS duration," +
      "    mileways_url AS milewaysUrl" +
      "    FROM flight" +
      "      LEFT JOIN place as departure" +
      "        ON departure.id = flight.departure_id" +
      "      LEFT JOIN place as arrival" +
      "      ON arrival.id = flight.arrival_id" +
      "      LEFT JOIN airline AS airline" +
      "        ON airline.id = flight.airline_id" +
      "    WHERE flight.active = TRUE" +
      "    ORDER BY departureTime DESC", nativeQuery = true)
  List<FlightResult> findAllFlights();

  /*
  MYSQL Convert TZ // Does not work in PGSQL
  "    CONVERT_TZ(departure_time, 'UTC', departure.time_zone_name) AS departureTime," +
      "    CONVERT_TZ(arrival_time, 'UTC', arrival.time_zone_name) AS arrivalTime," +
   */

  @Query(value = 	"SELECT" +
      "    flight.id AS id," +
      "    flight.flight_number as flightNumber," +
      "    departure.iata AS departureIata," +
      "    departure.name AS departureName," +
      "    departure.city AS departureCity," +
      "    departure.country_code AS departureCountryCode," +
      "    departure.country_name AS departureCountryName," +
      "    departure.latitude AS departureLatitude," +
      "    departure.longitude AS departureLongitude," +
      "    arrival.iata AS arrivalIata," +
      "    arrival.name AS arrivalName," +
      "    arrival.city AS arrivalCity," +
      "    arrival.country_code AS arrivalCountryCode," +
      "    arrival.country_name AS arrivalCountryName," +
      "    arrival.latitude AS arrivalLatitude," +
      "    arrival.longitude AS arrivalLongitude," +
      "    airline.code AS airlineCode," +
      "    airline.name AS airlineName," +
      "    departure_time AT time zone 'utc' AT time zone departure.time_zone_name AS departureTime," +
      "    arrival_time AT time zone 'utc' AT time zone arrival.time_zone_name AS arrivalTime," +
      "    miles AS miles," +
      "    duration AS duration," +
      "    mileways_url AS milewaysUrl" +
      "    FROM flight" +
      "      LEFT JOIN place as departure" +
      "        ON departure.id = flight.departure_id" +
      "      LEFT JOIN place as arrival" +
      "      ON arrival.id = flight.arrival_id" +
      "      LEFT JOIN airline AS airline" +
      "        ON airline.id = flight.airline_id" +
      "    WHERE flight.active = TRUE" +
      "      AND departure_time AT time zone 'UTC' at time zone departure.time_zone_name < CURRENT_DATE" +
      "    ORDER BY departureTime DESC", nativeQuery = true)
  List<FlightResult> findAllPastFlights();

  @Query(value = 	"SELECT" +
      "    flight.id AS id," +
      "    flight.flight_number as flightNumber," +
      "    departure.iata AS departureIata," +
      "    departure.name AS departureName," +
      "    departure.city AS departureCity," +
      "    departure.country_code AS departureCountryCode," +
      "    departure.country_name AS departureCountryName," +
      "    departure.latitude AS departureLatitude," +
      "    departure.longitude AS departureLongitude," +
      "    arrival.iata AS arrivalIata," +
      "    arrival.name AS arrivalName," +
      "    arrival.city AS arrivalCity," +
      "    arrival.country_code AS arrivalCountryCode," +
      "    arrival.country_name AS arrivalCountryName," +
      "    arrival.latitude AS arrivalLatitude," +
      "    arrival.longitude AS arrivalLongitude," +
      "    airline.code AS airlineCode," +
      "    airline.name AS airlineName," +
      "    departure_time AT time zone 'utc' AT time zone departure.time_zone_name AS departureTime," +
      "    arrival_time AT time zone 'utc' AT time zone arrival.time_zone_name AS arrivalTime," +
      "    miles AS miles," +
      "    duration AS duration," +
      "    mileways_url AS milewaysUrl" +
      "    FROM flight" +
      "      LEFT JOIN place as departure" +
      "        ON departure.id = flight.departure_id" +
      "      LEFT JOIN place as arrival" +
      "      ON arrival.id = flight.arrival_id" +
      "      LEFT JOIN airline AS airline" +
      "        ON airline.id = flight.airline_id" +
      "    WHERE flight.active = TRUE" +
          "      AND departure_time AT time zone 'UTC' at time zone departure.time_zone_name > CURRENT_DATE" +
      "    ORDER BY departureTime ASC", nativeQuery = true)
  List<FlightResult> findAllUpcomingFlights();

  @Query(value = "SELECT arrival.iata as arrivalIata"
          + ", departure.iata as departureIata"
          + ", departure.latitude as departureLatitude"
          + ", departure.longitude as departureLongitude"
          + ", arrival.latitude as arrivalLatitude"
          + ", arrival.longitude as arrivalLongitude"
          + " from flight"
          + " LEFT JOIN place as departure"
          + " ON departure.id = flight.departure_id"
          + " LEFT JOIN place as arrival"
          + "   ON arrival.id = flight.arrival_id"
          + " WHERE arrival.iata < departure.iata"
          + "   AND flight.departure_time > CURRENT_DATE"
          + " UNION"
          + " SELECT arrival.iata as arrivalIata"
          + " , departure.iata as departureIata"
          + " , departure.latitude as departureLatitude"
          + " , departure.longitude as departureLongitude"
          + " , arrival.latitude as arrivalLatitude"
          + " , arrival.longitude as arrivalLongitude"
          + " from flight"
          + " LEFT JOIN place as departure"
          + "  ON departure.id = flight.departure_id"
          + " LEFT JOIN place as arrival"
          + "  ON arrival.id = flight.arrival_id"
          + " WHERE departure.iata < arrival.iata"
          + "  AND flight.departure_time > CURRENT_DATE",
      nativeQuery = true)
  List<RouteResult> findUpcomingRoutes();

  @Query(value = "SELECT arrival.iata as arrivalIata"
          + ", departure.iata as departureIata"
          + ", departure.latitude as departureLatitude"
          + ", departure.longitude as departureLongitude"
          + ", arrival.latitude as arrivalLatitude"
          + ", arrival.longitude as arrivalLongitude"
          + " from flight"
          + " LEFT JOIN place as departure"
          + " ON departure.id = flight.departure_id"
          + " LEFT JOIN place as arrival"
          + "   ON arrival.id = flight.arrival_id"
          + " WHERE arrival.iata < departure.iata"
          + "   AND flight.departure_time < CURRENT_DATE"
          + " UNION"
          + " SELECT arrival.iata as arrivalIata"
          + " , departure.iata as departureIata"
          + " , departure.latitude as departureLatitude"
          + " , departure.longitude as departureLongitude"
          + " , arrival.latitude as arrivalLatitude"
          + " , arrival.longitude as arrivalLongitude"
          + " from flight"
          + " LEFT JOIN place as departure"
          + "  ON departure.id = flight.departure_id"
          + " LEFT JOIN place as arrival"
          + "  ON arrival.id = flight.arrival_id"
          + " WHERE departure.iata < arrival.iata"
          + "  AND flight.departure_time < CURRENT_DATE",
          nativeQuery = true)
  List<RouteResult> findPastRoutes();

  /*
  @Query(value= """
    SELECT
    id,
    departure_id,
    arrival_id,
    departure_time,
    arrival_time,
    miles,
    duration,
    mileways_url
    FROM flight
    WHERE id = :id
      AND active = TRUE
    ORDER BY updated_at DESC
          """, nativeQuery= true)
  FlightResult findFlightById(Long id);

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
   */
}
