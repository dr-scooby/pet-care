package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;

public interface UserFactory {

    public User createUser(RegistrationRequest rr);
}
