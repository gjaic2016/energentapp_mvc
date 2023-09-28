package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepositoryJpa extends JpaRepository<Owner, Integer> {
}
