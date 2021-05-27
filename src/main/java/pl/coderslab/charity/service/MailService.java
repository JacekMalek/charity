package pl.coderslab.charity.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("troll.cool@poczta.fm");

        msg.setSubject(subject);
        msg.setText(content);

        javaMailSender.send(msg);
    }
}

//Inna wersja, też działa
//
//    private final JavaMailSender javaMailSender;
//
//    public MailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void sendSimpleEmail(String to, String subject, String content) throws MessagingException {
//        MimeMessage msg = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(msg, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
//        helper.setTo(to);
//        helper.setFrom("troll.cool@poczta.fm");
//
//        helper.setSubject(subject);
//        helper.setText(content);
//
//        javaMailSender.send(msg);
//    }
//}