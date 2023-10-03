package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.City;
import hr.apisit.energentmvc.jpaRepository.CityRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private CityRepositoryJpa cityRepositoryJpa;

    @Override
    public List<City> getAllCities() {
        return cityRepositoryJpa.findAll();
    }

    @Override
    public Optional<City> getCityById(Integer id) {
        return cityRepositoryJpa.findById(id);
    }

    @Override
    public void saveCity(City newCity) {

    }

    @Override
    public Optional<City> updateCity(City updatedCity, Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteCity(Integer id) {

    }
}
