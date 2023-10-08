package hr.apisit.energentmvc.jpaRepository;

import hr.apisit.energentmvc.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryJpa extends JpaRepository<Role, Integer> {

    Role findByRolename(String rolename);
//    findByUsername(String username);

}
