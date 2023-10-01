package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Contract;
import hr.apisit.energentmvc.exception.EntityNotFoundException;
import hr.apisit.energentmvc.jpaRepository.ContractRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private ContractRepositoryJpa contractRepositoryJpa;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepositoryJpa.findAll();
    }

    @Override
    public Optional<Contract> getContractById(Integer id) {
        return contractRepositoryJpa.findById(id);
    }

    @Override
    public void saveContract(Contract newContract) {
        contractRepositoryJpa.save(newContract);
    }

    @Override
    public Optional<Contract> updateContract(Contract contractToUpdate, Integer originalContractId) {
        //TODO contract update

        Optional<Contract> modifiedContractOptional = contractRepositoryJpa.findById(originalContractId);

        if (modifiedContractOptional.isPresent()) {
            Contract modifiedContract = modifiedContractOptional.get();

            modifiedContract.setContractType(contractToUpdate.getContractType());
            modifiedContract.setHousehold(contractToUpdate.getHousehold());
            modifiedContract.setServiceSP(contractToUpdate.getServiceSP());
            modifiedContract.setStart_date(contractToUpdate.getStart_date());
            modifiedContract.setEnddate(contractToUpdate.getEnddate());

            Optional<Contract> newUpdatedContract = Optional.of(contractRepositoryJpa.save(modifiedContract));

            return newUpdatedContract;
        } else {
            throw new EntityNotFoundException("There is no Owner object for ID = '" + originalContractId + "'");
        }

    }

    @Override
    public void deleteContract(Integer id) {
        contractRepositoryJpa.delete(getContractById(id).get());
    }


}
