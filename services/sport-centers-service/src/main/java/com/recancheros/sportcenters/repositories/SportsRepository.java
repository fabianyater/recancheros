package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportsRepository extends JpaRepository<Sport, Long> {
    List<Sport> findBySportCenter_Id(Long id);
}
