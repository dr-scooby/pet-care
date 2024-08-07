package com.jahcodework.universal_pet_care.service.user;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userrepo;



    public void add(User user){

        userrepo.save(user);

    }
}
