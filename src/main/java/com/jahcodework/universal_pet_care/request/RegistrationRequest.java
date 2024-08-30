package com.jahcodework.universal_pet_care.request;

import jakarta.persistence.Column;
import lombok.Data;
// DTO - data transfer class, in DTO don't use the User class directly.
@Data
public class RegistrationRequest {
    // same attributes as the User. this will be used to transfer the data.
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    //@Column(name="mobile")
    private String phoneNumber;
    //@Column(unique = true)
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled; // is user active
    private String specialization;
}
