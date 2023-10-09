package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Address;
import hr.apisit.energentmvc.domain.City;
import hr.apisit.energentmvc.domain.Role;
import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.service.RoleService;
import hr.apisit.energentmvc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    @GetMapping
    public String getUsersPage(Model model){
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        return "usersList";
    }

    @GetMapping("/new")
    public String getTemplateForNewUser(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/new")
    public String saveNewUser(Model model, @ModelAttribute User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role defaultRole = roleService.getRoleById(1).get();
        user.setRoles(Collections.singleton(defaultRole));

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    //TODO update
    @GetMapping("/update/{id}")
    public String getUpdateScreen(Model model, @PathVariable Integer id) {
        User userToUpdate = userService.getUserById(id).get();
        userToUpdate.setPassword("");
        model.addAttribute("user", userToUpdate);
        return "updateUser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role defaultRole = roleService.getRoleById(1).get();
        user.setRoles(Collections.singleton(defaultRole));

        userService.saveUser(user);
        return "redirect:/users";
    }


}
