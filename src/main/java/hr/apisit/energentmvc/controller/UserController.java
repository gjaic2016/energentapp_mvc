package hr.apisit.energentmvc.controller;

import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public String getUsersPage(Model model){
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        return "usersList";
    }

}
