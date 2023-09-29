package hr.apisit.energentmvc.jpaRepository;


import hr.apisit.energentmvc.domain.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepositoryJpa extends JpaRepository<ServiceType, Integer> {
}
