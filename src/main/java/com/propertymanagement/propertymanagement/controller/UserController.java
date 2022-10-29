package com.propertymanagement.propertymanagement.controller;

import com.propertymanagement.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.propertymanagement.dto.UserDTO;
import com.propertymanagement.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/propertymanagement/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")       //URL :http://localhost:8080/propertymanagement/v1/user/register (its a post method)
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO){
        userDTO =   userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
