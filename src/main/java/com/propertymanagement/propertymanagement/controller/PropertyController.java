package com.propertymanagement.propertymanagement.controller;

import com.propertymanagement.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propertymanagement/v1")   //class level mapping of a URL to a controller class.
public class PropertyController {

    @Autowired                                  //dependency injection is done here.
    private PropertyService propertyService;


    //mapping page keyword need to be mapped to controller.
    @GetMapping("/hello")                   //this mapping can be solely done for function only, but its good for
    public String sayHello(){               //maintaining  a URL for class too.
        return("Hello");
    }


    //URL : http://localhost:8080/propertymanagement/v1/save

    @PostMapping("/save")       //URL :http://localhost:8080/propertymanagement/v1/save (its a post method)
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO =   propertyService.saveProperty(propertyDTO);
//        System.out.println(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    //creating another method that returns all The properties as responseEntity.
    //first add this method to repository interface.
    @GetMapping("/properties")  //URL : http://localhost:8080/propertymanagement/v1/properties
    public ResponseEntity<List<PropertyDTO>> getAlProperties(){
        List<PropertyDTO> propertyList= propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    //method to update a record.calling uodateProperty method fromservice layer.
    @PutMapping("/properties/{propertyId}")      //path variable : {propertyId}
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/delete-by-id/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
            propertyService.deleteProperty(propertyId);
            ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            return responseEntity;

    }

}
