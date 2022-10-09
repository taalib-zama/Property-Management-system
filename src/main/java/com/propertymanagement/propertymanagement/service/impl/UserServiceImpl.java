package com.propertymanagement.propertymanagement.service.impl;

import com.propertymanagement.propertymanagement.converter.UserConverter;
import com.propertymanagement.propertymanagement.dto.UserDTO;
import com.propertymanagement.propertymanagement.entity.UserEntity;
import com.propertymanagement.propertymanagement.exception.BusinessException;
import com.propertymanagement.propertymanagement.exception.ErrorModel;
import com.propertymanagement.propertymanagement.repository.UserRepository;
import com.propertymanagement.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<ErrorModel>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL LARADT EXIST");
            errorModel.setMessage("THE EMAIL WE'RE TRYING TO REGISTER ALERADY EXIST");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity =  userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<ErrorModel>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
