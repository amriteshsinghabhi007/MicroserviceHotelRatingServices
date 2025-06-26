package com.micorservices.userservices.Creating.the.user.service.controller;

import com.micorservices.userservices.Creating.the.user.service.entities.User;
import com.micorservices.userservices.Creating.the.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //Create user
    @PostMapping
   public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //Get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
       User user = userService.getUser(userId);
       return ResponseEntity.ok(user);
    }
    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getAlluser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
