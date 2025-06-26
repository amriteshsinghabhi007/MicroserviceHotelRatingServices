package com.micorservices.hotelservice.HotelService.service.impl;

import com.micorservices.hotelservice.HotelService.entities.Hotel;
import com.micorservices.hotelservice.HotelService.exception.ResourceNotFoundException;
import com.micorservices.hotelservice.HotelService.repository.HotelRepository;
import com.micorservices.hotelservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String randomUUID = UUID.randomUUID().toString();
        hotel.setId(randomUUID);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getSingleHotelDetail(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel not found with given id"));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
