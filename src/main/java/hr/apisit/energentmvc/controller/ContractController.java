package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Contract;
import hr.apisit.energentmvc.domain.Household;
import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("contracts")
@AllArgsConstructor
public class ContractController {

    private ContractService contractService;

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

//    @GetMapping("/new")
//    public String getTemplateForNewContract(Model model){
//        List<Owner> owners = ownerService.getAllOwners(); //getat contract tyoe
//
//        model.addAttribute("owners", owners);
//        // getat household
//        // getat service id
//        // upis start date
//        // upis end date
//        // odabir status iz enuma
//        model.addAttribute("contract", new Contract());
//
//        return "newContract";
//    }

}
