package hr.apisit.energentmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class TestController {

    @GetMapping
    public String getHomePage(){
        return "home";
    }

}
