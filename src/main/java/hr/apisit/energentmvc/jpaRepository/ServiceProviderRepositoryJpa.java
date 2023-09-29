package hr.apisit.energentmvc.jpaRepository;


import hr.apisit.energentmvc.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceProviderRepositoryJpa extends JpaRepository<ServiceProvider,Integer> {
}
