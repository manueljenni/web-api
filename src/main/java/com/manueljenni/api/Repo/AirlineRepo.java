package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Airline;
import com.manueljenni.api.Result.AirlineResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirlineRepo extends JpaRepository<Airline, Long> {

    @Query(value = """
            SELECT id AS id
            FROM airline            
            WHERE code = :code
            LIMIT 1
            """, nativeQuery = true)
    AirlineResult getAirlineByCode(String code);

}
