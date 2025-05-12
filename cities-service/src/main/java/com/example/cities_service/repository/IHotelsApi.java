package com.example.cities_service.repository;

import com.example.cities_service.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelsApi {
    @GetMapping("/hotels/{city_id}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable Long city_id);
}
