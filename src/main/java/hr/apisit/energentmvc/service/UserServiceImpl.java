package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.jpaRepository.UserRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveUser(User newUser) {
//        User definedUser = new User();
//        definedUser.setUsername(newUser.getUsername());
//        definedUser.setPassword(newUser.getPassword());
//        definedUser.setRoles();



        userRepositoryJpa.save(newUser);
    }

    @Override
    public User updateUser(User updatedUser, Integer id) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }
}
