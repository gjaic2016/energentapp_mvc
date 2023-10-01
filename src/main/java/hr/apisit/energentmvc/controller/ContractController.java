package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.*;
import hr.apisit.energentmvc.service.ContractService;
import hr.apisit.energentmvc.service.ContractTypeService;
import hr.apisit.energentmvc.service.HouseholdService;
import hr.apisit.energentmvc.service.ServiceSPService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("contracts")
@AllArgsConstructor
public class ContractController {

    private ContractService contractService;
    private ContractTypeService contractTypeService;
    private HouseholdService householdService;
    private ServiceSPService serviceSPService;

    @GetMapping
    public String getContractsPage(Model model) {
        List<Contract> contractsList = contractService.getAllContracts();
        model.addAttribute("contracts", contractsList);
        return "contractsList";
    }

    @GetMapping("/{id}")
    public String getContractId( Model model, @PathVariable Integer id) {
        Contract contract = contractService.getContractById(id).get();
        model.addAttribute("contract", contract);
        return "contractDetails";
    }

    @GetMapping("/new")
    public String getTemplateForNewContract(Model model){
        // get contracttype
        List<ContractType> contractTypes = contractTypeService.getAllContractTypes();
        model.addAttribute("contracttypes", contractTypes);

        // get household
        List<Household> households = householdService.getAllHouseholds();
        model.addAttribute("households", households);

        // get service id
        List<ServiceSP> serviceSPs = serviceSPService.getAllServices();
        model.addAttribute("servicesps", serviceSPs);

        // input start date
        // input end date

        // select status from enum
        model.addAttribute("statuslist", Status.values());

        model.addAttribute("contract", new Contract());

        return "newContract";
    }

    @PostMapping("/new")
    public String saveNewContract(Model model, @ModelAttribute Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    //TODO update

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Integer id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }

}
