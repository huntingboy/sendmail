package com.nomad.service;

import com.nomad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendMail {

    @Autowired
    JavaMailSender mailSender;
    
    public void sendSimpleUserEmail(String to, User user){
        SimpleMailMessage message = new SimpleMailMessage();
        String username = user.getUsername();
        message.setFrom("13197367227@163.com");
        message.setTo(to);
        message.setSubject("Test Username");
        message.setText("username:" + user.getUsername() + "; age:" + user.getAge());
        mailSender.send(message);
    }
}
