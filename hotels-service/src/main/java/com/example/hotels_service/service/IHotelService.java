package com.example.hotels_service.service;

import com.example.hotels_service.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getHotelsByCityId(Long city_id);
}
