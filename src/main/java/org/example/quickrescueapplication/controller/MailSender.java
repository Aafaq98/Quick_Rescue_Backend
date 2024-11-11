package org.example.quickrescueapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.awt.SystemColor.text;

@RestController
@RequestMapping("/api/mail")
public class MailSender {

//@Autowired
//   private JavaMailSender javaMailSender;

    @GetMapping
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("aafiahmed@gmail.com");
        message.setSubject("subject");
        message.setText("text");
        message.setFrom("aafiahmednew@gmail.com");

        //javaMailSender.send(message);
    }
}
