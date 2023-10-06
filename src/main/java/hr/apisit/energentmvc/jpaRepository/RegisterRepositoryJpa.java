package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepositoryJpa extends JpaRepository<User, Integer> {
}
