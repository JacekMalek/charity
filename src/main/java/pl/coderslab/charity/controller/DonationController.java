package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Dto.CategoryDto;
import pl.coderslab.charity.Dto.DonationDto;
import pl.coderslab.charity.Dto.InstitutionDto;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private final CategoryServiceImpl categoryServiceImpl;
    private final InstitutionServiceImpl institutionServiceImpl;
    private final DonationServiceImpl donationServiceImpl;

    public DonationController(CategoryServiceImpl categoryServiceImpl,
                              InstitutionServiceImpl institutionServiceImpl, DonationServiceImpl donationServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
        this.institutionServiceImpl = institutionServiceImpl;
        this.donationServiceImpl = donationServiceImpl;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("donationDto", new DonationDto());
        return "form";
    }

    @PostMapping("/form")
    public String form(@Valid DonationDto donationDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        donationServiceImpl.add(donationDto);
        return "redirect:form-confirmation";
    }

    @GetMapping("/form-confirmation")
    public String confirmation(){
        return "/form-confirmation";
    }

    @ModelAttribute("formCategories")
    public List<CategoryDto> categories(){
        return categoryServiceImpl.getAll();
    }

    @ModelAttribute("formInstitutions")
    public List<InstitutionDto> institutions(){
        return institutionServiceImpl.getAll();
    }

}
