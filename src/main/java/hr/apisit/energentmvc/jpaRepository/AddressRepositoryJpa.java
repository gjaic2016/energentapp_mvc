package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryJpa extends JpaRepository<Address, Integer> {
}
