package com.jahcodework.universal_pet_care.controller;

import com.jahcodework.universal_pet_care.dto.EntityConverter;
import com.jahcodework.universal_pet_care.dto.UserDTO;
import com.jahcodework.universal_pet_care.exception.UserAlreadyExistsException;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.response.ApiResponse;
import com.jahcodework.universal_pet_care.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

// localhost:9192/pet-care
@RequiredArgsConstructor
@RequestMapping("/pet-care")
@RestController
public class UserController {
    private final UserService userService;

    private final EntityConverter<User, UserDTO> entityConverter;



    // localhost:9192/pet-care/addUser
    @PostMapping("/addUser")
    public void add(@RequestBody User auser){
        System.out.println("\n\n" + "User received: " + auser.toString() + "\n\n");
        userService.add(auser);
    }


    //localhost:9192/pet-care/addNewUser
    @PostMapping("/addNewUser")
    public ResponseEntity<ApiResponse> addNewUser(@RequestBody RegistrationRequest request){

        try{
            // create the user
            User auser = userService.add(request);
            UserDTO registerdUser = entityConverter.mapEntityToDto(auser, UserDTO.class);

            return ResponseEntity.ok(new ApiResponse("User registered successfully", registerdUser));

        }catch(UserAlreadyExistsException e){
            //return ResponseEntity.ok(new ApiResponse(e.getMessage(), null)); // ok is response 200 ok to client
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

        }
    }

    //localhost:9192/pet-care/addAUser
   @PostMapping("/addAUser")
    public User add(@RequestBody RegistrationRequest request){

       // return this info back to client, so client will receive as json
       return userService.add(request);
    }
}
