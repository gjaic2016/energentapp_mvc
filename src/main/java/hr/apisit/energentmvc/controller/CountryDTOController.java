package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Country;
import hr.apisit.energentmvc.dtoDomain.CountryDTO;
import hr.apisit.energentmvc.dtoMapper.CountryMapper;
import hr.apisit.energentmvc.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("countrydto")
@AllArgsConstructor
public class CountryDTOController {

    private CountryService countryService;

    @GetMapping
    public String getCountries(Model model) {
        List<Country> countries = countryService.getAllCountries();

        List<CountryDTO> countryDTOs = countries.stream()
                .map(CountryMapper::mapToDTO)
                .collect(Collectors.toList());
        model.addAttribute("countriesd", countryDTOs);
        return "countryListDto";
    }


}
