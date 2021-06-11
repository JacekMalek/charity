package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class DonationController {

    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;

    public DonationController(CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("donationDto", new DonationDto());
        model.addAttribute("emailDto", new EmailDto());
        return "form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute EmailDto emailDto, @Valid DonationDto donationDto,
                       BindingResult bindingResult, @AuthenticationPrincipal CurrentUser currentUser) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        donationService.addUser(donationDto, currentUser);
        return "redirect:form-confirmation";
    }

    @GetMapping("/form-confirmation")
    public String confirmation(Model model) {
        model.addAttribute("emailDto", new EmailDto());
        return "/form-confirmation";
    }

    @ModelAttribute("formCategories")
    public List<CategoryDto> categories() {
        return categoryService.getAll();
    }

    @ModelAttribute("formInstitutions")
    public List<InstitutionDto> institutions() {
        return institutionService.getAll();
    }

}
