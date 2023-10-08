package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.jpaRepository.RegisterRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepositoryJpa registerRepositoryJpa;

    @Override
    public void saveRegisterUser(User newUser) {
        registerRepositoryJpa.save(newUser);
    }
}
