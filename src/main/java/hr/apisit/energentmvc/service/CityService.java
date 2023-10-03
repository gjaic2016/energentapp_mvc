package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.City;
import hr.apisit.energentmvc.domain.Contract;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> getAllCities();

    Optional<City> getCityById(Integer id);

    void saveCity(City newCity);

    Optional<City> updateCity(City updatedCity, Integer id);

    void deleteCity(Integer id);
}
