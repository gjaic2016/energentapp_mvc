package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("owners")
@AllArgsConstructor
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping
    public String getOwnersPage(Model model){
        List<Owner> ownerList = ownerService.getAllOwners();
        model.addAttribute("owners", ownerList);
        return "ownersList";
    }

    @GetMapping("/{id}")
    public String getOwnerById(Model model, @PathVariable Integer id) {
        Owner owner = ownerService.getOwnerById(id).get();
        model.addAttribute("owner", owner);
        return "ownerDetails";
    }

    @GetMapping("/new")
    public String getTemplateForNewOwner(Model model){
        model.addAttribute("owner", new Owner());

        return "newOwner";
    }

    @PostMapping("/new")
    public String saveNewOwner(Model model, @ModelAttribute Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Integer id) {
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }
}
