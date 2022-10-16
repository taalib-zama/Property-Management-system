package com.propertymanagement.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private String ownerName;
    private Long Id;
    @NotNull(message = "Owner email is madatory")
    @NotEmpty(message = "owner email cannot be empty")
    @Size(min = 1, max = 50, message = "owner email should be between 1 to 50 characters")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "password cannot be null")

    private String password;
}
