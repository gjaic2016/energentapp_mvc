package hr.apisit.energentmvc.dtoMapper;

import hr.apisit.energentmvc.domain.Country;
import hr.apisit.energentmvc.dtoDomain.CountryDTO;

public class CountryMapper {

    public static CountryDTO mapToDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();

//        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());

        return countryDTO;
    }

    public static Country mapToEntity(CountryDTO countryDTO) {
        Country country = new Country();

//        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());

        return country;
    }

}
