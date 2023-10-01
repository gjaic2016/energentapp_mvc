package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepositoryJpa extends JpaRepository<Contract, Integer> {
}
