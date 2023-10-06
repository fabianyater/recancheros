package com.recancheros.sportcenters.repositories;

import com.recancheros.sportcenters.model.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findBySportCenter_Id(Long id);

    Field findBySportCenter_IdAndId(Long id, Long id1);

}
