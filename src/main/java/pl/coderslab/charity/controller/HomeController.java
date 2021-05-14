package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
public class HomeController {

    private  final InstitutionServiceImpl institutionServiceImpl;


    public HomeController(InstitutionServiceImpl institutionService) {
        this.institutionServiceImpl = institutionService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionsFirst = institutionServiceImpl.getFirstHalf();
        List<Institution> institutionsSecond = institutionServiceImpl.getSecondHalf();
        model.addAttribute("institutionsFirst", institutionsFirst);
        model.addAttribute("institutionsSecond", institutionsSecond);
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
