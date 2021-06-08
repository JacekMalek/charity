package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.service.MailService;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @GetMapping("/sendEmail")
    public String sendEmail(Model model) {
       model.addAttribute("email", new EmailDto());
        return "email";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String name, @RequestParam String surname, @RequestParam String message) throws MessagingException {
        mailService.sendSimpleEmail("Jacek <jac.malek@gmail.com>",
                "Zapytanie z Charity", "Imię: " + name + "\n" + "Nazwisko: " + surname + "\n" + "Treść wiadomości: " +  message);
        return "email-confirmation";
    }

//    @GetMapping("email-confirmation")
//    public String emailConfirmation(){
//        return "email-confirmation";
//    }
}