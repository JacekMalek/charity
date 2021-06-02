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
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final DonationServiceImpl donationServiceImpl;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService, DonationServiceImpl donationServiceImpl) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.donationServiceImpl = donationServiceImpl;
    }


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("donationDto", new DonationDto());
        return "form";
    }

    @PostMapping("/form")
    public String form(@Valid DonationDto donationDto, BindingResult bindingResult, @AuthenticationPrincipal CurrentUser currentUser) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        donationServiceImpl.addUser(donationDto, currentUser);
        return "redirect:form-confirmation";
    }

    @GetMapping("/form-confirmation")
    public String confirmation() {
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
