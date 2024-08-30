package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.exception.UserAlreadyExistsException;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.repository.VetRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * this is not a factory design patter, only a simulation, just a mimick.
 */

@Component
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory{

    private final UserRepo userrepo;
    private final VetFactory vetfactory;
    private final PatientFactory patfactory;
    private final AdminFactory adminfactory;

    @Override
    public User createUser(RegistrationRequest rr) {

        // check if email exists, can only have 1 unique email
        if(userrepo.existsByEmail(rr.getEmail()) ){
            throw new UserAlreadyExistsException("oops! " + rr.getEmail() + " already exists");
        }

        switch (rr.getUserType()){

            case "VET" -> {return  vetfactory.createVet(rr); }

            case "PATIENT" -> {return patfactory.createPatient(rr); }

            case "ADMIN" -> {return adminfactory.createAdmin(rr); }

            default -> {
                return null;
            }
        }


    }
}
