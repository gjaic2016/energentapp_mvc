package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.ServiceSP;
import hr.apisit.energentmvc.exception.EntityNotFoundException;
import hr.apisit.energentmvc.jpaRepository.ServiceSPRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceSPImpl implements ServiceSPService {


    private ServiceSPRepositoryJpa serviceSPRepositoryJpa;

    @Override
    public List<ServiceSP> getAllServices() {
        return serviceSPRepositoryJpa.findAll();
    }

    @Override
    public Optional<ServiceSP> getServiceById(Integer id) {
        return serviceSPRepositoryJpa.findById(id);
    }

    @Override
    public void saveService(ServiceSP newServiceSP) {
        serviceSPRepositoryJpa.save(newServiceSP);
    }

    @Override
    public ServiceSP updateService(ServiceSP serviceSPToUpdate, Integer originalServiceSPId) {

        Optional<ServiceSP> modifiedServiceSPOptional = serviceSPRepositoryJpa.findById(originalServiceSPId);

        if(modifiedServiceSPOptional.isPresent()) {
            ServiceSP modifiedServiceSP = modifiedServiceSPOptional.get();

            modifiedServiceSP.setServiceProvider(serviceSPToUpdate.getServiceProvider());
            modifiedServiceSP.setServiceType(serviceSPToUpdate.getServiceType());
            modifiedServiceSP.setPrice(serviceSPToUpdate.getPrice());

            ServiceSP newUpdatedServiceSP = serviceSPRepositoryJpa.save(modifiedServiceSP);

            return newUpdatedServiceSP;
        }
        else {
            throw new EntityNotFoundException("There is no Service object for ID = '" + originalServiceSPId + "'");
        }
    }

    @Override
    public void deleteService(Integer id) {
        serviceSPRepositoryJpa.delete(getServiceById(id).get());
    }
}
