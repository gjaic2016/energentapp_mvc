package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepositoryJpa extends JpaRepository<Household,Integer > {
}
