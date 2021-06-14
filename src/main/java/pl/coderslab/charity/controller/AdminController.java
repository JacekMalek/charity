package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionServiceImpl institutionServiceImpl;

    public AdminController(InstitutionServiceImpl institutionServiceImpl) {
        this.institutionServiceImpl = institutionServiceImpl;
    }


    @GetMapping("/form")
    public String adminForm(Model model) {
        model.addAttribute("emailDto", new EmailDto());
        return "admin";
    }

    @GetMapping("/form/allInstitutions")
    public String allInstitutions(Model model) {
        List<InstitutionDto> institutions = institutionServiceImpl.getAll();
        model.addAttribute("allInstitutions", institutions);
        return "allInstitutions";
    }

    @GetMapping("/form/addInstitution")
    public String addInstitution(Model model){
        model.addAttribute("newInstitution", new InstitutionDto());
        return "addInstitution";
    }
}
