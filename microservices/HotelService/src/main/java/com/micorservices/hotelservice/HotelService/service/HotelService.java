package com.micorservices.hotelservice.HotelService.service;

import com.micorservices.hotelservice.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    Hotel getSingleHotelDetail (String id);

    List<Hotel> getAllHotel();
}
