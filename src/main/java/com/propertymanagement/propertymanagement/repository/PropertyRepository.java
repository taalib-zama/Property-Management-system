package com.propertymanagement.propertymanagement.repository;

import com.propertymanagement.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    
}
