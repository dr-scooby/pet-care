package com.jahcodework.universal_pet_care.dto;

import jakarta.persistence.Column;
import lombok.Data;

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
