package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Integer id);

    void saveUser(User newUser);

    User updateUser(User updatedUser, Integer id);

    void deleteUser(Integer id);

}
