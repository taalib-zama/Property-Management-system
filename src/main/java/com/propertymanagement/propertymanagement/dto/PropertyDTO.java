package com.propertymanagement.propertymanagement.dto;
import lombok.*;
@Getter
@Setter
public class PropertyDTO {
    //****************  MODEL class : Its used to hold the information which is coming from the client ******/
    //any property will have certain characteristics.
    private Long id;
    private String title;   //type of property 2BHK/3BHK.
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;

    //json : {
     /* {
        "title":"Property 1",
        "description":"3BHK",
        "ownerName":"Raj,
        "ownerEmail":
        "price"
        "address":
    }
*/
}
