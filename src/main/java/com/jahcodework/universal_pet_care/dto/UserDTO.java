package com.jahcodework.universal_pet_care.dto;

import jakarta.persistence.Column;
import lombok.Data;
/*
A Data Transfer Object (DTO) is a design pattern used to transfer data between software application subsystems or layers.
 DTOs are often used in the context of developing web applications, especially when working with complex domain models and APIs.
 They are simple, serializable objects that encapsulate the data you want to transfer;
 they do not contain any business logic but merely aggregate data that needs to be sent over the network.
 */
// Data used for gettter and setter from lombok
@Data
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String userType;
    private boolean isEnabled; // is user active
    private String specialization;

}
