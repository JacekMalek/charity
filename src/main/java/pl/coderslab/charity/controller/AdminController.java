package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionServiceImpl institutionServiceImpl;
    private final DonationServiceImpl donationServiceImpl;
    private final UserServiceImpl userServiceImpl;

    public AdminController(InstitutionServiceImpl institutionServiceImpl, DonationServiceImpl donationServiceImpl, UserServiceImpl userServiceImpl) {
        this.institutionServiceImpl = institutionServiceImpl;
        this.donationServiceImpl = donationServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/form")
    public String adminForm(Model model) {
        Long numberOfGifts = donationServiceImpl.numberOfGifts();
        Integer numberOfBags = donationServiceImpl.numberOfBags();
        Long numberOfInstitutions = institutionServiceImpl.numberOfInstitutions();
        Long numberOfUsers =  userServiceImpl.numberOfUsers();
        model.addAttribute("emailDto", new EmailDto());
        model.addAttribute("numberOfGifts", numberOfGifts);
        model.addAttribute("numberOfBags", numberOfBags);
        model.addAttribute("numberOfInstitutions", numberOfInstitutions);
        model.addAttribute("numberOfUsers", numberOfUsers);
        return "admin";
    }
}
