package com.jahcodework.universal_pet_care.controller;

import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<ApiResponse> add(@RequestBody RegistrationRequest request){

        try{
            User auser = userService.add(request);
        }catch(Exception e){

        }
    }
    /* public User add(@RequestBody RegistrationRequest request){

       return userService.add(request);
    }*/
}
