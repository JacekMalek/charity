package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String sendEmail(Model model) throws MessagingException {
        mailService.sendSimpleEmail("Jacek <troll.cool@poczta.fm>",
                "Test e-mail", "Testing email functionality");

        return "mail-confirmation";
    }
}