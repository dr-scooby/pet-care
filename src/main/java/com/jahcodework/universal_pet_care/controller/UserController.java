package com.jahcodework.universal_pet_care.controller;

import com.jahcodework.universal_pet_care.dto.EntityConverter;
import com.jahcodework.universal_pet_care.dto.UserDTO;
import com.jahcodework.universal_pet_care.exception.UserAlreadyExistsException;
import com.jahcodework.universal_pet_care.exception.UserNotFoundException;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.request.RegistrationRequest;
import com.jahcodework.universal_pet_care.request.UserUpdatedRequest;
import com.jahcodework.universal_pet_care.response.ApiResponse;
import com.jahcodework.universal_pet_care.service.user.UserService;
import com.jahcodework.universal_pet_care.utils.FeedBackMessage;
import com.jahcodework.universal_pet_care.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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
    @PostMapping(UrlMapping.ADDNEWUSER)
    public ResponseEntity<ApiResponse> addNewUser(@RequestBody RegistrationRequest request){

        try{
            // create the user
            User auser = userService.add(request);
            UserDTO registerdUser = entityConverter.mapEntityToDto(auser, UserDTO.class);

            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registerdUser));

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



    @PutMapping("/update/{userid}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long userid,@RequestBody UserUpdatedRequest request){
        try{
            System.out.println("Updating user: " + request.getFirstName() + " " + request.getLastName() );

            User theuser = userService.update(userid, request);
            UserDTO updateduser = entityConverter.mapEntityToDto(theuser, UserDTO.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS, updateduser));
        }catch(UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));

        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

        }
    }


    @GetMapping("/user/{userid}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long userid){

        try{
            User auser = userService.findById(userid);
            UserDTO userdto = entityConverter.mapEntityToDto(auser, UserDTO.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.FOUND, userdto));
        }catch(UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

        }
    }


    @DeleteMapping("/deleteuser/{userid}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long userid){

        try{
            userService.delete(userid);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS_DELETED, null));
        }catch(UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

        }
    }



    @GetMapping("/getallusers")
    public ResponseEntity<ApiResponse> getAllUsers(){
        List<UserDTO> theusers = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse(FeedBackMessage.ALL_USERS, theusers));
    }

}
