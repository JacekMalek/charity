package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Dto.InstitutionDto;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private  final InstitutionServiceImpl institutionServiceImpl;
    private final DonationServiceImpl donationServiceImpl;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionServiceImpl institutionService, DonationServiceImpl donationServiceImpl, InstitutionService institutionService1, DonationService donationService) {
        this.institutionServiceImpl = institutionService;
        this.donationServiceImpl = donationServiceImpl;
        this.institutionService = institutionService1;
        this.donationService = donationService;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        //TODO zapytać o wstrzykiwanie
//        List<InstitutionDto> institutions = institutionServiceImpl.getFirstFour();

        List<InstitutionDto> institutions = institutionService.getFirstFour();
        Long numberOfGifts = donationServiceImpl.numberOfGifts();
        //Integer numberOfBags = donationServiceImpl.numberOfBags();
        Integer numberOfBags = donationService.numberOfBags();
        model.addAttribute("institutions", institutions);
        model.addAttribute("numberOfGifts", numberOfGifts);
        model.addAttribute("numberOfBags", numberOfBags);
        return "index";
    }





}
