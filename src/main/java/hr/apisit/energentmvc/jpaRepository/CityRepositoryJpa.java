package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositoryJpa extends JpaRepository<City, Integer> {
}
