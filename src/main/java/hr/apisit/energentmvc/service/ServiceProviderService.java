package hr.apisit.energentmvc.service;


import hr.apisit.energentmvc.domain.ServiceProvider;

import java.util.List;


public interface ServiceProviderService {

    List<ServiceProvider> getAllServiceProviders();

    ServiceProvider getServiceProviderById(Integer id);

    void saveNewServiceProvider(ServiceProvider newServiceProvider);

    ServiceProvider updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id);

    void deleteServiceProvider(Integer id);

}
