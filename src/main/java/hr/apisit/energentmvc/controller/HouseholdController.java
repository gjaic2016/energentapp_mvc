package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Household;
import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.service.HouseholdService;
import hr.apisit.energentmvc.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("households")
@AllArgsConstructor
public class HouseholdController {

    private HouseholdService householdService;

    private OwnerService ownerService;

    @GetMapping
    public String getHouseholdsPage(Model model) {
        List<Household> householdsList = householdService.getAllHouseholds();
        model.addAttribute("households", householdsList);
        return "householdList";
    }

    @GetMapping("/{id}")
    public String getHouseholdId( Model model, @PathVariable Integer id) {
        Household household = householdService.getHouseholdById(id).get();
        model.addAttribute("household", household);
        return "householdDetails";
    }


    @GetMapping("/new")
    public String getTemplateForNewHousehold(Model model){
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);
        model.addAttribute("household", new Household());

        return "newHousehold";
    }

    @PostMapping("/new")
    public String saveNewHousehold(Model model, @ModelAttribute Household household) {
        householdService.saveHousehold(household);
        return "redirect:/households";
    }

    @GetMapping("/delete/{id}")
    public String deleteHousehold(@PathVariable Integer id) {
        householdService.deleteHousehold(id);
        return "redirect:/households";
    }
}
