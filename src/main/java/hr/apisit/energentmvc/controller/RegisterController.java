package hr.apisit.energentmvc.controller;


import hr.apisit.energentmvc.domain.Role;
import hr.apisit.energentmvc.domain.User;
import hr.apisit.energentmvc.service.RegisterService;
import hr.apisit.energentmvc.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("register")
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    @GetMapping("/new")
    public String getTemplateForNewRegisterUser(Model model){
        model.addAttribute("registeruser", new User());
        return "register";
    }

    @PostMapping("/new")
    public String saveNewUser(Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {

        if (registerService.usernameExists(user.getUsername())) {
            redirectAttributes.addFlashAttribute("errorMessage", " This username is already taken. Please choose a different one!");
            model.addAttribute("registeruser", true);
            return "redirect:/register/new";
        }
//        String username = user.getUsername();
//        boolean isUsernameTaken = registerService.usernameExists(username);
//        if (isUsernameTaken) {
//            model.addAttribute("usernameTaken", true);
//            return "register"; // Return to the registration form with an error message
//        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role defaultRole = roleService.getRoleById(1).get();
        user.setRoles(Collections.singleton(defaultRole));

        registerService.saveRegisterUser(user);
        return "redirect:/register/success"; //redirect to succesful page

    }



    @GetMapping("/success")
    public String getTemplateForSuccessRegister(Model model){
        return "successRegister";
    }

}
