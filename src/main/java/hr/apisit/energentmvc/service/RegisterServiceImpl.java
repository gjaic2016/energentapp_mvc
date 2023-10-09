package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.jpaRepository.RegisterRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepositoryJpa registerRepositoryJpa;

    @Override
    public List<User> getAllUsers() {
        return registerRepositoryJpa.findAll();
    }

    @Override
    public void saveRegisterUser(User newUser) {
        registerRepositoryJpa.save(newUser);
    }

    @Override
    public boolean usernameExists(String username) {
        User existingUser = registerRepositoryJpa.findByUsername(username);
        return existingUser != null;
    }
}
