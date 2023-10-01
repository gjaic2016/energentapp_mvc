package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    List<Contract> getAllContracts();

    Optional<Contract> getContractById(Integer id);

    void saveContract(Contract newContract);

    Optional<Contract> updateContract(Contract updatedContract, Integer id);

    void deleteContract(Integer id);

}
