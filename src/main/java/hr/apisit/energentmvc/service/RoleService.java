package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAllRoles();

    Optional<Role> getRoleById(Integer id);

//    void saveUser(Role newRole);

//    Role updateRole(Role updatedRole, Integer id);

//    void deleteRole(Integer id);
}
