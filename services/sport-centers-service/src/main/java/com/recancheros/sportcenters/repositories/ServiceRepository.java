package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findBySportCenter_Id(Long id);
}
