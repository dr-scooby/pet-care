package com.jahcodework.universal_pet_care.factory;

import com.jahcodework.universal_pet_care.model.Admin;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.AdminRepo;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFactory {

    private final AdminRepo adrepo;
    private final UserAttributesMapper userattr;


    public User createAdmin(RegistrationRequest rr) {

        Admin ad = new Admin();
        userattr.setCommonAttributes(rr, ad);


        return adrepo.save(ad);
    }
}
