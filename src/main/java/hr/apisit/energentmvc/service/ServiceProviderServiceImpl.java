package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.ServiceProvider;
import hr.apisit.energentmvc.exception.EntityNotFoundException;
import hr.apisit.energentmvc.jpaRepository.ServiceProviderRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService{

    private ServiceProviderRepositoryJpa serviceProviderRepositoryJpa;

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepositoryJpa.findAll();
    }

    @Override
    public ServiceProvider getServiceProviderById(Integer id) {
        return serviceProviderRepositoryJpa.findById(id).get();
    }

    @Override
    public void saveNewServiceProvider(ServiceProvider newServiceProvider) {
        serviceProviderRepositoryJpa.save(newServiceProvider);
    }

    @Override
    public ServiceProvider updateServiceProvider(ServiceProvider serviceProviderToUpdate, Integer originalServiceProviderId) {

        Optional<ServiceProvider> modifiedSProviderOptional = serviceProviderRepositoryJpa.findById(originalServiceProviderId);

        if(modifiedSProviderOptional.isPresent()) {
            ServiceProvider modifiedServiceProvider = modifiedSProviderOptional.get();

            modifiedServiceProvider.setNaziv(serviceProviderToUpdate.getNaziv());
            modifiedServiceProvider.setAdresa(serviceProviderToUpdate.getAdresa());

            ServiceProvider newUpdatedServiceProvider = serviceProviderRepositoryJpa.save(modifiedServiceProvider);

            return newUpdatedServiceProvider;
        }
        else {
            throw new EntityNotFoundException("There is no provider object for ID = '" + originalServiceProviderId + "'");
        }

    }

    @Override
    public void deleteServiceProvider(Integer id) {
        serviceProviderRepositoryJpa.delete(serviceProviderRepositoryJpa.findById(id).get());
    }

}
