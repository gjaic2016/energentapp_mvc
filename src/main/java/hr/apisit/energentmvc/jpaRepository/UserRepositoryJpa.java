package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
