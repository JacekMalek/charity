package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

    @RequestMapping("/form")
    public String form(Model model){
        return "form";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        return "register";
    }

}
