package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sports, Long> {
}
