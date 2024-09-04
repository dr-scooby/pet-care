package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.factory.UserFactory;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepo userrepo;

    private final UserFactory userfactory;


    @Override
    public User add(RegistrationRequest register){

       return userfactory.createUser(register);

    }

    public void add(User auser){
        userrepo.save(auser);

    }
}
