package com.propertymanagement.propertymanagement.controller;

import com.propertymanagement.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator/v1")
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam("num1") Double num1 , @RequestParam("num2") Double num2){
        return (num1+num2);
    }

    //map the values of URL to java variables by path  variable method.
    @GetMapping("/sub/{num1}/{num2}")
    public double subtract(@PathVariable("num1") Double num1, @PathVariable("num2")Double num2) {
        Double result = null;
        if (num1 > num2) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }
        return result;
    }


    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2()*calculatorDTO.getNum3();
        //creating a custom response code.
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;          //here the datatype is changes to responseEntity. this will contain both the data and status code.
    }
    //{
    //    "num1":65.43,
    //    "num2":56.5,
    //    "num3":2.1,
    //    "num4":11.0
    //}
}
