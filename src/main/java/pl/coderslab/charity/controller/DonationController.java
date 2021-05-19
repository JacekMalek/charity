package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.Dto.DonationDto;
import pl.coderslab.charity.service.CategoryServiceImpl;

@Controller
public class DonationController {

    private final CategoryServiceImpl categoryServiceImpl;

    public DonationController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("donationDto", new DonationDto());
        model.addAttribute("formCategories", categoryServiceImpl.getAll());
        return "form";
    }

}
