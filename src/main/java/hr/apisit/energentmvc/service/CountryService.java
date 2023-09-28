package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getAllCountries();

    Optional<Country> getCountryById(Integer id);

    void saveCountry(Country newCountry);

    Country updateCountry(Country updatedCountry, Integer id);

    void deleteCountry(Integer id);
}
