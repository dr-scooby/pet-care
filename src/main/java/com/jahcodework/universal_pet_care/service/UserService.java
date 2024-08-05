package com.jahcodework.universal_pet_care.service;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepo userrepo;


    public void add(User user){

    }
}
