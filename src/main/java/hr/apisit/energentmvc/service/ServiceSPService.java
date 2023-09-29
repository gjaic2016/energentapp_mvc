package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.ServiceSP;

import java.util.List;
import java.util.Optional;

public interface ServiceSPService {

    List<ServiceSP> getAllServices();

    Optional<ServiceSP> getServiceById(Integer id);

    void saveService(ServiceSP newServiceSP);

    ServiceSP updateService(ServiceSP updatedServiceSP, Integer id);

    void deleteService(Integer id);
}
