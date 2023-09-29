package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Address;
import hr.apisit.energentmvc.domain.Household;
import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.domain.ServiceProvider;
import hr.apisit.energentmvc.service.AddressService;
import hr.apisit.energentmvc.service.ServiceProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("serviceproviders")
@AllArgsConstructor
public class ServiceProviderController {

    private ServiceProviderService serviceProviderService;

    private AddressService addressService;

    @GetMapping
    public String getServiceProviderPage(Model model){
        List<ServiceProvider> providerList = serviceProviderService.getAllServiceProviders();
        model.addAttribute("providers", providerList);
        return "providerList";
    }

    @GetMapping("/{id}")
    public String getServiceProviderId( Model model, @PathVariable Integer id) {
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
        model.addAttribute("provider", serviceProvider);
        return "providerDetails";
    }

    @GetMapping("/new")
    public String getTemplateForNewProvider(Model model){
        List<Address> addresses = addressService.getAllAddresses();
        model.addAttribute("addresses", addresses);
        model.addAttribute("provider", new ServiceProvider());

        return "newProvider";
    }

    @PostMapping("/new")
    public String saveNewProvider(Model model, @ModelAttribute ServiceProvider serviceProvider) {
        serviceProviderService.saveNewServiceProvider(serviceProvider);
        return "redirect:/serviceproviders";
    }

    //TODO update

    @GetMapping("/delete/{id}")
    public String deleteHousehold(@PathVariable Integer id) {
        serviceProviderService.deleteServiceProvider(id);
        return "redirect:/serviceproviders";
    }

}
