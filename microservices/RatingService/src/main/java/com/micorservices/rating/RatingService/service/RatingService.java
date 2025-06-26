package com.micorservices.rating.RatingService.service;

import com.micorservices.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRating();

    List<Rating> getAllratingByUserId(String userId);
    List<Rating> getAllratingByHotelId(String hotelId);
}
