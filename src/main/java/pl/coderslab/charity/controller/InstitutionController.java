package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class InstitutionController {

    private final InstitutionServiceImpl institutionServiceImpl;

    public InstitutionController(InstitutionServiceImpl institutionService) {
        this.institutionServiceImpl = institutionService;
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

    @PostMapping("/form/addInstitution")
    public String addInstitution(InstitutionDto institutionDto){
        institutionServiceImpl.add(institutionDto);
        return "redirect:/admin/form/allInstitutions";
    }

    @GetMapping("/form/deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionServiceImpl.delete(id);
        return "redirect:/admin/form/allInstitutions";
    }


}
