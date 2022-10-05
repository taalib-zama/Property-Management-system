package com.propertymanagement.propertymanagement.service.impl;

import com.propertymanagement.propertymanagement.converter.PropertyConverter;
import com.propertymanagement.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.propertymanagement.entity.PropertyEntity;
import com.propertymanagement.propertymanagement.repository.PropertyRepository;
import com.propertymanagement.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service                        //this makes sure that object is created only once while the application is running.
                                // Also called singleton behaviour.Since they have only one property called bean.
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO){
        //retreiving property entity and assign it to propertyEntity object.
//        PropertyEntity pe = new PropertyEntity();
//        pe.setTitle(propertyDTO.getTitle());
//        pe.setAddress(propertyDTO.getAddress());
//        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
//        pe.setDescription(propertyDTO.getDescription());
//        pe.setOwnerName(propertyDTO.getOwnerName());
//        pe.setPrice(propertyDTO.getPrice());
        //herer we are first coneverting to entity so we can save then convertingback to DTO so we can return DTO.
        // SO NOW FROM OUR SERVICE LAYER THE DTO WILLBE RETURNED.
        PropertyEntity pe  = propertyConverter.conevrtDTOtoEntity(propertyDTO); //CONVERTING TO ENTITY SO WE CAN SAVE.

        pe = propertyRepository.save(pe);        //property DTO should be of prototype type.
        //save the propertyrepository in same variable after saving , post save it will have the autognerated id too

        PropertyDTO dto = propertyConverter.converEntitytoDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        //using for lopto convert each ENTITY TO DTO.
        for(PropertyEntity pe : listOfProps){
            PropertyDTO dto = propertyConverter.converEntitytoDTO(pe);
            propList.add(dto);
        }
        return propList;            //list of DTO objects
        //after implementing this method here we can call it from Controller class.
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyID);
        PropertyDTO dto = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
//            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setDescription(propertyDTO.getDescription());
    //            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.converEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyID);
        PropertyDTO dto = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();

            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.converEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyID);
        PropertyDTO dto = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();

            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.converEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}
