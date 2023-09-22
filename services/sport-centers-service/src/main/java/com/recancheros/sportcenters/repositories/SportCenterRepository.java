package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportCenterRepository extends JpaRepository<SportCenter, Long> {
}
