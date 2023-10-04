package hr.apisit.energentmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
@AllArgsConstructor
public class LoginController {

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

}
