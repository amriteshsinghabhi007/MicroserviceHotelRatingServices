package com.ads.electronic.store.ElectronicStore.services;

import com.ads.electronic.store.ElectronicStore.dtos.UserDto;
import com.ads.electronic.store.ElectronicStore.entity.User;

import java.util.List;

public interface UserServices {
    //create
    public UserDto createUser(UserDto userDto);
    //update
    public UserDto userUpdate(UserDto userDto, String userId);
    //delete
    public void userDelete(String userId);
    //get single id
    public UserDto getSingleUser(String userId);
    //get all
    public List<UserDto> getAllUser();
    //get email id
    public UserDto getUserByEmail(String emailId);

    //search user
    public List<UserDto> searchUser(String keyword);

}
