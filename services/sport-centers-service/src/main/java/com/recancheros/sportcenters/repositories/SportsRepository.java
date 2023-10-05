package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sport, Long> {
}
