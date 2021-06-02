package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.MailService;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final MailService mailService;

    public HomeController(InstitutionServiceImpl institutionService, DonationServiceImpl donationService, MailService mailService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.mailService = mailService;
    }


    @GetMapping("/")
    public String homeAction(Model model) {
        List<InstitutionDto> institutions = institutionService.getFirstFour();
        Long numberOfGifts = donationService.numberOfGifts();
        Integer numberOfBags = donationService.numberOfBags();
        model.addAttribute("institutions", institutions);
        model.addAttribute("numberOfGifts", numberOfGifts);
        model.addAttribute("numberOfBags", numberOfBags);
        return "index";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername() + " " + entityUser.getId() + " " + entityUser.getPassword();
    }
}
