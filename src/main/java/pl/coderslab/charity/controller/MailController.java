package pl.coderslab.charity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.service.MailService;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/")
public class MailController {

    private final MailService mailService;
    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute EmailDto emailDto, @RequestParam String name, @RequestParam String surname, @RequestParam String message) throws MessagingException {
        mailService.sendSimpleEmail("Jacek <jac.malek@gmail.com>",
                "Zapytanie z Charity", "Imię: " + name + "\n" + "Nazwisko: " + surname + "\n" + "Treść wiadomości: " +  message);
        log.info("Wysłano email");
        return "email-confirmation";
    }
}