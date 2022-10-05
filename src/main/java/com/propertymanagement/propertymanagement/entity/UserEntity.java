package com.propertymanagement.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id                 //below coloumn will be treated as a PK coloumn.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //MOVING USERNAMEAND USER EMAIL FROM Property Entity
    private String ownerName;
    @Column(name = "EMAIL",unique = true, nullable = false)
    private String ownerEmail;
    private String phone;
    private String password;
}
