package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.*;
import hr.apisit.energentmvc.service.AddressService;
import hr.apisit.energentmvc.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;
    private CityService cityService;

    @GetMapping
    public String getAddressPage(Model model) {
        List<Address> addressList = addressService.getAllAddresses();
        model.addAttribute("addresses", addressList);
        return "addressList";
    }

    @GetMapping("/{id}")
    public String getAddressId( Model model, @PathVariable Integer id) {
        Address address = addressService.getAddressById(id).get();
        model.addAttribute("contract", address);
        return "addressDetails";
    }

    @GetMapping("/new")
    public String getTemplateForNewAddress(Model model){
        // get cities
        List<City> citiesList = cityService.getAllCities();
        model.addAttribute("cities", citiesList);
        model.addAttribute("newaddress", new Address());
        return "newAddress";
    }

    @PostMapping("/new")
    public String saveNewAddress(Model model, @ModelAttribute Address address) {
        addressService.saveAddress(address);
        return "redirect:/address";
    }

    //TODO update
    @GetMapping("/update/{id}")
    public String getUpdateScreen(Model model, @PathVariable Integer id) {
        List<City> citiesList = cityService.getAllCities();
        model.addAttribute("cities", citiesList);

        Address addressToUpdate = addressService.getAddressById(id).get();
        model.addAttribute("address", addressToUpdate);
        return "updateAddress";
    }

    @PostMapping("/update")
    public String updateAddress(@ModelAttribute Address address) {
        addressService.saveAddress(address);
        return "redirect:/address";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return "redirect:/address";
    }
}