package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final MailService mailService;


    public HomeController(InstitutionService institutionService, DonationService donationService, MailService mailService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String homeAction(Model model){
        List<InstitutionDto> institutions = institutionService.getFirstFour();
        Long numberOfGifts = donationService.numberOfGifts();
        Integer numberOfBags = donationService.numberOfBags();
        model.addAttribute("institutions", institutions);
        model.addAttribute("numberOfGifts", numberOfGifts);
        model.addAttribute("numberOfBags", numberOfBags);
        return "index";
    }

}
