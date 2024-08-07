package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.exception.UserAlreadyExistsException;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.repository.VetRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;

public class SimpleUserFactory implements UserFactory{

    private UserRepo userrepo;
    private VetFactory vetfactory;
    private PatientFactory patfactory;
    private AdminFactory adminfactory;

    @Override
    public User createUser(RegistrationRequest rr) {

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
