package com.micorservices.hotelservice.HotelService.repository;

import com.micorservices.hotelservice.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String>{
}
