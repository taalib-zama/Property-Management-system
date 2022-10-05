package com.propertymanagement.propertymanagement.service.impl;

import com.propertymanagement.propertymanagement.converter.UserConverter;
import com.propertymanagement.propertymanagement.dto.UserDTO;
import com.propertymanagement.propertymanagement.entity.UserEntity;
import com.propertymanagement.propertymanagement.repository.UserRepository;
import com.propertymanagement.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String passowrd) {
        return null;
    }
}
