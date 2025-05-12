package com.example.cities_service.service;

import com.example.cities_service.dto.CityDTO;
import com.example.cities_service.dto.HotelDTO;
import com.example.cities_service.model.City;
import com.example.cities_service.repository.IHotelsApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private IHotelsApi iHotelsApi;

    List<City> cities = new ArrayList<>();

    @Override
    public CityDTO getHotelsByCityId(String city_name, String city_country) {
        this.loadCities();
        City city = this.findCity(city_name, city_country);

        List<HotelDTO> hotelsOfCity = iHotelsApi.getHotelsByCityId(city.getCity_id());

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setState(city.getState());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setHotelsList(hotelsOfCity);
        return cityDTO;
    }

    public City findCity(String city_name, String city_country){
        for (City cit : cities) {
            if (cit.getName().equalsIgnoreCase(city_name) && cit.getCountry().equalsIgnoreCase(city_country)) {
                return cit;
            }
        }
        return null;
    }

    public void loadCities(){
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));
    }
}
