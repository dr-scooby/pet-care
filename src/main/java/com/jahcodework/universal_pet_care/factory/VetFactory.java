package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.model.Vet;
import com.jahcodework.universal_pet_care.repository.VetRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetFactory {

    private final VetRepo vetrepo;
    private final UserAttributesMapper userattrmapper;

    public User createVet(RegistrationRequest rr) {

        Vet veter = new Vet();
        userattrmapper.setCommonAttributes(rr, veter);
        veter.setSpecialization(rr.getSpecialization());

        return vetrepo.save(veter);
    }
}
