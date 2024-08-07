package com.jahcodework.universal_pet_care.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegistrationRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(name="mobile")
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled; // is user active
    private String specialization;
}
