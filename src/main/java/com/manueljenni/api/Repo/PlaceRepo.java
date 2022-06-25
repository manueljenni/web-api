package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Place;
import com.manueljenni.api.Entity.Point;
import com.manueljenni.api.Result.PlaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlaceRepo extends JpaRepository<Place, Long> {

    @Query(value = 	"SELECT" +
        "            id, " +
        "            type," +
        "            iata," +
        "            name," +
        "            city," +
        "            country_name," +
        "            country_code," +
        "            latitude," +
        "            longitude" +
        "            FROM place            " +
        "            WHERE iata = :iata" +
        "              AND type = 1" +
        "              AND active = TRUE" +
        "            LIMIT 1", nativeQuery = true)
    PlaceResult getAirportIdByIata(String iata);
}
