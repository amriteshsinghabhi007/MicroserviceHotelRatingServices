package com.micorservices.rating.RatingService.controller;

import com.micorservices.rating.RatingService.entities.Rating;
import com.micorservices.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> allRating = ratingService.getAllRating();
        return ResponseEntity.ok(allRating);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> getRatingByUserId = ratingService.getAllratingByUserId(userId);
        return ResponseEntity.ok(getRatingByUserId);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> getRatingByHotelId = ratingService.getAllratingByHotelId(hotelId);
        return ResponseEntity.ok(getRatingByHotelId);
    }
}
