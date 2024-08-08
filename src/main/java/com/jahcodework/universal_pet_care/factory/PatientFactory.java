package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.model.Patient;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.PatientRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientFactory {

    private final UserAttributesMapper userattrmapper;

    private final PatientRepo pat;

    public User createPatient(RegistrationRequest rr) {

        Patient patient = new Patient();
        userattrmapper.setCommonAttributes(rr, patient);

        //System.out.println("new Patient:: " + patient + " " + patient.getFirstName() + " " + patient.getEmail());

        return pat.save(patient);
    }
}
