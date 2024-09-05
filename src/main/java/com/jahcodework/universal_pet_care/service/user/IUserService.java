package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.dto.UserDTO;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.request.UserUpdatedRequest;

import java.util.List;

public interface IUserService {
    User add(RegistrationRequest register);

    User update(Long userid, UserUpdatedRequest userrequest);

    User findById(Long userid);

    void delete(Long userid);

    List<UserDTO> getAllUsers();
}
