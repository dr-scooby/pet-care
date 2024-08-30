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

// localhost:9192/pet-care
@RequiredArgsConstructor
@RequestMapping("/pet-care")
@RestController
public class UserController {
    private final UserService userService;




    // localhost:9192/pet-care/addUser
    @PostMapping("/addUser")
    public void add(@RequestBody User auser){
        System.out.println("\n\n" + "User received: " + auser.toString() + "\n\n");
        userService.add(auser);
    }


   /* @PostMapping
    public ResponseEntity<ApiResponse> add(@RequestBody RegistrationRequest request){

        try{
            User auser = userService.add(request);
        }catch(Exception e){

        }
    }*/
   @PostMapping("/addAUser")
    public User add(@RequestBody RegistrationRequest request){

       // return this info back to client, so client will receive as json
       return userService.add(request);
    }
}
