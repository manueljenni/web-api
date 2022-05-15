package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepo extends JpaRepository<Point, Long> {

}
