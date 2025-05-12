package com.example.cities_service.service;

import com.example.cities_service.dto.CityDTO;

public interface ICityService {
    CityDTO getHotelsByCityId(String city_name, String city_country);
}
