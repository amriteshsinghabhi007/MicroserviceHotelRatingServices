package com.micorservices.userservices.Creating.the.user.service.service;

import com.micorservices.userservices.Creating.the.user.service.entities.User;

import java.util.List;

public interface UserService {

    //Create user
    User saveUser(User user);

    //getAll User
    List<User> getAllUser();

    //get single user
    User getUser(String userId);
}
