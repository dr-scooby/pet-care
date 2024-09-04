package com.jahcodework.universal_pet_care.request;

import lombok.Data;

@Data
public class UserUpdatedRequest {

    // only allowed to changed the following fields:
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String specialization;
}
