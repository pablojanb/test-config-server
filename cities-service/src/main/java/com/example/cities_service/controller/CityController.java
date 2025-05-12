package com.example.cities_service.controller;

import com.example.cities_service.dto.CityDTO;
import com.example.cities_service.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService iCityService;

    @GetMapping("/hotels")
    public CityDTO getHotelsByCityId(@RequestParam String city_name,
                                     @RequestParam String city_country){
        return iCityService.getHotelsByCityId(city_name, city_country);
    }
}
