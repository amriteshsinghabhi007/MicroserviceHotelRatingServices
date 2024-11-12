package com.ads.orm.Spring_Orm.services.impl;

import com.ads.orm.Spring_Orm.repositories.UserRepositories;
import com.ads.orm.Spring_Orm.entity.User;
import com.ads.orm.Spring_Orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepositories userRepositories;
    @Override
    public User saveUser(User user) {
        User saveUser = userRepositories.save(user);
        logger.info("save user {}",saveUser.getId());
        return saveUser;
    }

    @Override
    public User updateUser(User user, int userId) {
        User getUser = userRepositories.findById(userId).orElseThrow(()->new RuntimeException("Given User not found"));
        getUser.setName(user.getName());
        getUser.setAge(user.getAge());
        getUser.setCity(user.getCity());
        User userUpdate=userRepositories.save(getUser);
        return userUpdate;
    }

    @Override
    public void deleteUser(int userID) {
        User getUser = userRepositories.findById(userID).orElseThrow(()->new RuntimeException("Given User not found"));
        userRepositories.delete(getUser);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userAll = userRepositories.findAll();
        return userAll;
    }

    @Override
    public User getSingleUser(int userId) {
        Optional<User> optionalUser= userRepositories.findById(userId);
        User getUser = optionalUser.orElseThrow(()->new RuntimeException("Given User not found"));
        return getUser;
    }
}
