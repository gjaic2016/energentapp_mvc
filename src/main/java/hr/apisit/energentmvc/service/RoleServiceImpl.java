package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Role;
import hr.apisit.energentmvc.jpaRepository.RoleRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{

    private RoleRepositoryJpa roleRepositoryJpa;

    @Override
    public List<Role> getAllRoles() {
        return roleRepositoryJpa.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Integer id) {
        return roleRepositoryJpa.findById(id);
    }
}
