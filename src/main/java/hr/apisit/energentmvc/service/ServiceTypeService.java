package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.ServiceType;

import java.util.List;
import java.util.Optional;

public interface ServiceTypeService {

    List<ServiceType> getAllServiceTypes();

    Optional<ServiceType> getServiceTypeById(Integer id);

    void saveServiceType(ServiceType newServiceType);

    ServiceType updateServiceType(ServiceType updatedServiceType, Integer id);

    void deleteServiceType(Integer id);

}
