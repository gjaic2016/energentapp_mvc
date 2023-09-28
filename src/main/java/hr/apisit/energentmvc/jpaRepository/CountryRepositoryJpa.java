package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryJpa extends JpaRepository<Country,Integer> {
}
