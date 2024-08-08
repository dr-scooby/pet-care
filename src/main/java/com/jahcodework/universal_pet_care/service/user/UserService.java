package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.factory.UserFactory;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userrepo;

    private final UserFactory userfactory;


    public User add(RegistrationRequest register){

       return userfactory.createUser(register);

    }
}
