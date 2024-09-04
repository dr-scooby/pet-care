package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;

public interface IUserService {
    User add(RegistrationRequest register);
}
