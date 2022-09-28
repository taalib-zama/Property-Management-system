package com.propertymanagement.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id                 //below coloumn will be treated as a PK coloumn.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;   //type of property 2BHK/3BHK.
    private String description;
    private String ownerName;
    @Column(name = "EMAIL",unique = true, nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;
}
