package com.propertymanagement.propertymanagement.repository;

import com.propertymanagement.propertymanagement.entity.PropertyEntity;
import com.propertymanagement.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
}
