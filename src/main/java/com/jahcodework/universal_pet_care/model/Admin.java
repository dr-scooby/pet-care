package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{

    private long id;
    private String firstname;
    private String lastname;
    private String gender;
    private String phonenumber;
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled; // is user active


}
