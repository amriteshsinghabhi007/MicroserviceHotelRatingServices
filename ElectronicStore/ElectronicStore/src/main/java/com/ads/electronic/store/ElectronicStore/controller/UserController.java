package com.ads.electronic.store.ElectronicStore.controller;

import com.ads.electronic.store.ElectronicStore.dtos.ApiResponseMessage;
import com.ads.electronic.store.ElectronicStore.dtos.UserDto;
import com.ads.electronic.store.ElectronicStore.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;
    //Create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userCreated = userServices.createUser(userDto);
        return new ResponseEntity<>(userCreated, HttpStatus.OK);
    }
    //Update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> userUpdate(
            @PathVariable String userId,
            @RequestBody UserDto userDto
    ){
        UserDto userupdated = userServices.userUpdate(userDto,userId);
        return new ResponseEntity<>(userupdated,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> userDeleted(@PathVariable ("userId") String userId){
       userServices.userDelete(userId);
       ApiResponseMessage message = ApiResponseMessage.builder().mesaage("user is deleted successfully !!").success(true).status(HttpStatus.OK).build();
       return new ResponseEntity<>(message,HttpStatus.OK);
    }
     // get All user
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userServices.getAllUser(),HttpStatus.OK);
    }
    //Get single user by Id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(
            @PathVariable String userId
    ){
       return new ResponseEntity<>(userServices.getSingleUser(userId),HttpStatus.OK);
    }
    //get by Email
    @GetMapping("/email/{emailId}")
    public ResponseEntity<UserDto> getUserByEmail(
            @PathVariable String emailId
    ){
        return new ResponseEntity<>(userServices.getUserByEmail(emailId),HttpStatus.OK);
    }

    //get user by seach keyword
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<UserDto>> getUserByKeyword(
            @PathVariable String keyword
    ){
        return new ResponseEntity<>(userServices.searchUser(keyword),HttpStatus.OK);
    }
}
