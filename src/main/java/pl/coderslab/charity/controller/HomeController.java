package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Dto.InstitutionDto;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class HomeController {

    private  final InstitutionServiceImpl institutionServiceImpl;
    private final DonationServiceImpl donationServiceImpl;

    public HomeController(InstitutionServiceImpl institutionService, DonationServiceImpl donationServiceImpl) {
        this.institutionServiceImpl = institutionService;
        this.donationServiceImpl = donationServiceImpl;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        List<InstitutionDto> institutions = institutionServiceImpl.getFirstFour();
        Long numberOfGifts = donationServiceImpl.numberOfGifts();
        Optional<Integer> numberOfBags = donationServiceImpl.numberOfBags();
        model.addAttribute("institutions", institutions);
        model.addAttribute("numberOfGifts", numberOfGifts);
        model.addAttribute("numberOfBags", numberOfBags);
        return "index";
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
