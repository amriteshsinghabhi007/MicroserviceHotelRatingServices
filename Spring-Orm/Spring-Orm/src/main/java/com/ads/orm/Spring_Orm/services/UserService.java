package com.ads.orm.Spring_Orm.services;

import com.ads.orm.Spring_Orm.entity.User;

import java.util.List;

public interface UserService{

    public User saveUser(User user);
    public User updateUser(User user,int userId);
    public void deleteUser(int userID);
    public List<User> getAllUser();
    public User getSingleUser(int userId);

}
