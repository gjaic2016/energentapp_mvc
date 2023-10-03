package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Contract;
import hr.apisit.energentmvc.domain.Country;
import hr.apisit.energentmvc.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping
    public String getCountryPage(Model model){
        List<Country> countryList = countryService.getAllCountries();
        model.addAttribute("countries", countryList);
        return "countryList";
    }

    @GetMapping("/{id}")
    public String getCountryId( Model model, @PathVariable Integer id) {
        Country country = countryService.getCountryById(id).get();
        model.addAttribute("country", country);
        return "countryDetails";
    }

}
