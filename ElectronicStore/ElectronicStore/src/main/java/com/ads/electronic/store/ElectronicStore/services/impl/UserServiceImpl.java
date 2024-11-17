package com.ads.electronic.store.ElectronicStore.services.impl;

import com.ads.electronic.store.ElectronicStore.dtos.UserDto;
import com.ads.electronic.store.ElectronicStore.entity.User;
import com.ads.electronic.store.ElectronicStore.exception.ResourceNotFoundException;
import com.ads.electronic.store.ElectronicStore.repositories.UserRepositories;
import com.ads.electronic.store.ElectronicStore.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
   private UserRepositories userRepositories;
    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //Genrate unique userid string formate
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);
        //Dto to entity
        User user = dtoToEntity(userDto);
        User saveedUser = userRepositories.save(user);
        //entity to dto
        UserDto newDto = entityToDto(saveedUser);
        return newDto;
    }

    @Override
    public UserDto userUpdate(UserDto userDto, String userId) {
        User user = userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found!!"));
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        user.setUserImage(userDto.getUserImage());

        User userSave = userRepositories.save(user);
        UserDto updateDto = entityToDto(userSave);
        return updateDto;
    }

    @Override
    public void userDelete(String userId) {
        User user = userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found for Delete!!"));
        //delete user
        userRepositories.delete(user);
    }

    @Override
    public UserDto getSingleUser(String userId) {
        User user = userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not get from the userId!!"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepositories.findAll();
        List<UserDto> userDtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getUserByEmail(String emailId) {
        User userEmail = userRepositories.findByEmail(emailId).orElseThrow(()->new ResourceNotFoundException("User not found with this email Id!!"));
        return entityToDto(userEmail);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        Optional<User> userSearch= userRepositories.findByNameContaining(keyword);
        List<UserDto> listUserDto = userSearch.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return listUserDto;
    }

    private UserDto entityToDto(User saveedUser) {

        //Manually Converting entity to DTO
//        UserDto userDto = UserDto.builder()
//                .userId(saveedUser.getUserId())
//                .name(saveedUser.getName())
//                .about(saveedUser.getAbout())
//                .gender(saveedUser.getGender())
//                .email(saveedUser.getEmail())
//                .password(saveedUser.getPassword())
//                .userImage(saveedUser.getUserImage()).build();

//Using the model mapper converting Entity to Dto
        return mapper.map(saveedUser,UserDto.class) ;
    }

    private User dtoToEntity(UserDto userDto) {

        //Manually converting Dto to Entity
//        User user = User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .gender(userDto.getGender())
//                .about(userDto.getAbout())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .userImage(userDto.getUserImage()).build();

        //Using the model mapper converting Dto to Entity
        return mapper.map(userDto,User.class);
    }
}
