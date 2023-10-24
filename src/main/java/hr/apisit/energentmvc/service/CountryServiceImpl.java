package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Country;
import hr.apisit.energentmvc.exception.EntityNotFoundException;
import hr.apisit.energentmvc.jpaRepository.CountryRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private CountryRepositoryJpa countryRepositoryJpa;

    @Override
    public List<Country> getAllCountries() {
        return countryRepositoryJpa.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Integer id) {
        return countryRepositoryJpa.findById(id);
    }

    @Override
    public void saveCountry(Country newCountry) {
        countryRepositoryJpa.save(newCountry);
    }

    @Override
    public Country updateCountry(Country countryToUpdate, Integer originalCountryId) {

        Optional<Country> modifiedCountryOptional = countryRepositoryJpa.findById(originalCountryId);

        if(modifiedCountryOptional.isPresent()) {
            Country modifiedCountry = modifiedCountryOptional.get();
            modifiedCountry.setName(countryToUpdate.getName());
            Country newUpdatedCountry = countryRepositoryJpa.save(modifiedCountry);
            return newUpdatedCountry;
        }
        else {
            throw new EntityNotFoundException("There is no country object for ID = '" + originalCountryId + "'");
        }
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepositoryJpa.delete(getCountryById(id).get());
    }
}
