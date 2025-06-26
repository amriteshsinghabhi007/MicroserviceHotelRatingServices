package com.micorservices.hotelservice.HotelService.controller;

import com.micorservices.hotelservice.HotelService.entities.Hotel;
import com.micorservices.hotelservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotelDetail(@PathVariable String hotelId){
        Hotel singleHotelDetail = hotelService.getSingleHotelDetail(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(singleHotelDetail);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotelDetails(){
        List<Hotel> allHotel = hotelService.getAllHotel();
        return ResponseEntity.ok(allHotel);
    }
}
