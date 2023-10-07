package com.recancheros.fieldsservice.repositories;

import com.recancheros.fieldsservice.model.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findBySportCenterId(Long sportCenterId);

    Field findBySportCenterIdAndId(Long sportCenterId, Long id);

}
