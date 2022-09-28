package com.propertymanagement.propertymanagement.service;

import com.propertymanagement.propertymanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllProperties();     //since we're returning all properties we don't need any paramtere to function.
    //the returned format should be a list of all DB data.
    //this method should be implemented in serviceImpl class.


    //to update a record :
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID);
    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyID);
    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, Long propertyID);
    void deleteProperty(Long propertyId);


}
