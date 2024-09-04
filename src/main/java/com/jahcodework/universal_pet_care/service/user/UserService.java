package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.exception.UserNotFoundException;
import com.jahcodework.universal_pet_care.factory.UserFactory;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.request.UserUpdatedRequest;
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


    @Override
    public User update(Long userid, UserUpdatedRequest userrequest){

        User auser = findById(userid);
        auser.setFirstName(userrequest.getFirstName());
        auser.setLastName(userrequest.getLastName());
        auser.setPhoneNumber(userrequest.getPhoneNumber());
        auser.setGender(userrequest.getGender());
        auser.setSpecialization(userrequest.getSpecialization());


        return userrepo.save(auser);
    }

    @Override
    public User findById(Long userid) {
        return userrepo.findById(userid).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
