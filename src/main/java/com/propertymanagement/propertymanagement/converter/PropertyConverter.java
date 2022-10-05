package com.propertymanagement.propertymanagement.converter;

import com.propertymanagement.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity conevrtDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();   //saving into DB
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
//        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setDescription(propertyDTO.getDescription());
//        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());
        return pe;
    }
    public PropertyDTO converEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();        //returnig from db
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setDescription(propertyEntity.getDescription());
//        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
//        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setPrice(propertyEntity.getPrice());
        return propertyDTO;
    }
}
