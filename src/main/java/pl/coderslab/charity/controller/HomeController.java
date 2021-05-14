package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Dto.InstitutionDto;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private  final InstitutionServiceImpl institutionServiceImpl;

    public HomeController(InstitutionServiceImpl institutionService) {
        this.institutionServiceImpl = institutionService;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        List<InstitutionDto> institutions = institutionServiceImpl.getFirstFour();
        model.addAttribute("institutions", institutions);
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model){
        return "form";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

}
