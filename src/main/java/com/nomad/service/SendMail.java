package com.nomad.service;

import com.nomad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SendMail {

    @Autowired
    JavaMailSenderImpl mailSender;

    //简单邮件SimpleMailMessage
    public void sendSimpleUserEmail(String to, User user){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(to);
        message.setSubject("test sendSimpleUserEmail");
        message.setText("username:" + user.getUsername() + "; age:" + user.getAge());
        mailSender.send(message);
    }

    //带附件邮件MimeMessage  MimeMessageHelper
    public void sendUserEmailWithAttachment(String to, User user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailSender.getUsername());
        helper.setTo(to);
        helper.setSubject("test sendUserEmailWithAttachment");
        helper.setText("username:" + user.getUsername() + "; age:" + user.getAge());
        //FileSystemResource headerImage = new FileSystemResource("/.../header.jpeg");
        ClassPathResource headerImage = new ClassPathResource("header.jpeg");
        helper.addAttachment("headerImage.jpeg", headerImage);
        mailSender.send(message);
    }

    //发送富文本邮件 类似附件邮件 （html可以使用模板，比如thymeleaf, velocity）
    public void sendRichUserEmail(String to, User user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailSender.getUsername());
        helper.setTo(to);
        helper.setSubject("test sendRichUserEmail");
        helper.setText("<html><body><img src='cid:headerImage'>" +
                "<h1>" + user.getUsername() + "</h1><h2>" + user.getAge() +
                "</h2><h4>" + user.getSex() + "</h4>");
        ClassPathResource headerImage = new ClassPathResource("header.jpeg");
        helper.addInline("headerImage.jpeg", headerImage);
        mailSender.send(message);
    }

}
