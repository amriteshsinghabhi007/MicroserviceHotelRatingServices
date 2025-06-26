package com.micorservices.userservices.Creating.the.user.service.service.impl;

import com.micorservices.userservices.Creating.the.user.service.entities.User;
import com.micorservices.userservices.Creating.the.user.service.exception.ResourceNotFoundException;
import com.micorservices.userservices.Creating.the.user.service.model.Hotel;
import com.micorservices.userservices.Creating.the.user.service.model.Rating;
import com.micorservices.userservices.Creating.the.user.service.repository.UserRepository;
import com.micorservices.userservices.Creating.the.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given UserID" + userId));
        Rating[] ratingsOfUser = restTemplate.getForEntity("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating[].class).getBody();
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> body = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = body.getBody();
            logger.info("Status code " + body.getStatusCode());

            rating.setHotel(hotel);

            return  rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
