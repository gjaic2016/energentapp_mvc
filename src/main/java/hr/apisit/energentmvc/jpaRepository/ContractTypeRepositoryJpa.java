package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractTypeRepositoryJpa extends JpaRepository<ContractType, Integer> {
}
