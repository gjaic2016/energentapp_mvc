package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.*;
import hr.apisit.energentmvc.service.ServiceProviderService;
import hr.apisit.energentmvc.service.ServiceSPService;
import hr.apisit.energentmvc.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("services")
@AllArgsConstructor
public class ServiceSPController {

    private ServiceSPService serviceSPService;

    private ServiceProviderService serviceProviderService;

    private ServiceTypeService serviceTypeService;

    @GetMapping
    public String getServicesSPPage(Model model) {
        List<ServiceSP> servicessp = serviceSPService.getAllServices();
        model.addAttribute("services", servicessp);
        return "servicesList";
    }

    @GetMapping("/{id}")
    public String getServicesSPId( Model model, @PathVariable Integer id) {
        ServiceSP servicesp = serviceSPService.getServiceById(id).get();
        model.addAttribute("service", servicesp);
        return "serviceDetails";
    }

    @GetMapping("/new")
    public String getTemplateForNewServiceSP(Model model){
        List<ServiceProvider> serviceProviders = serviceProviderService.getAllServiceProviders();
        model.addAttribute("providers", serviceProviders);

        List<ServiceType> serviceTypes = serviceTypeService.getAllServiceTypes();
        model.addAttribute("servicetypes", serviceTypes);

        model.addAttribute("servicesp", new ServiceSP());

        return "newServiceSP";
    }

    @PostMapping("/new")
    public String saveNewServiceSP(Model model, @ModelAttribute ServiceSP servicesp) {
        serviceSPService.saveService(servicesp);
        return "redirect:/services";
    }

    //TODO update

    @GetMapping("/delete/{id}")
    public String deleteServiceSP(@PathVariable Integer id) {
        serviceSPService.deleteService(id);
        return "redirect:/services";
    }

}
