package com.propertymanagement.propertymanagement.service;

import com.propertymanagement.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String passowrd);

}
