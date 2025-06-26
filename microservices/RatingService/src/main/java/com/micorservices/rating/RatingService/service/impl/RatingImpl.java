package com.micorservices.rating.RatingService.service.impl;

import com.micorservices.rating.RatingService.entities.Rating;
import com.micorservices.rating.RatingService.repository.RatingRepository;
import com.micorservices.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        String randomId =UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllratingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllratingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
