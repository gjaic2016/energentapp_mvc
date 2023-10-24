package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.User;

import java.util.List;
import java.util.Optional;

public interface RegisterService {

    List<User> getAllUsers();

    void saveRegisterUser(User newUser);

    boolean usernameExists(String username);
}
