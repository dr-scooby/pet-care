package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import org.springframework.stereotype.Component;

//spring bean use @Component
@Component
public class UserAttributesMapper {

    // RegistrationRequest source is the data incoming
    public void setCommonAttributes(RegistrationRequest source, User target){
        // get the data from the source, and set it to the target
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setEnabled(source.isEnabled());
        target.setUserType(source.getUserType());

    }


}
