package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.ContractType;

import java.util.List;
import java.util.Optional;

public interface ContractTypeService {

    List<ContractType> getAllContractTypes();

    Optional<ContractType> getContractTypeById(Integer id);

    void saveContractType(ContractType newContractType);

    ContractType updateContractType(ContractType updatedContractType, Integer id);

    void deleteContractType(Integer id);

}
