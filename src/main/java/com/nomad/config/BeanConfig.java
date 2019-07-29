package com.nomad.config;

import com.nomad.service.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
//@ComponentScan
@PropertySource(value = "classpath:mail.properties")
public class BeanConfig {

    @Autowired
    Environment environment;

    @Bean
    public MailSender mailSender(Environment environment) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mailserver.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("mailserver.port")));
        mailSender.setUsername(environment.getProperty("mailserver.username"));
        mailSender.setPassword(environment.getProperty("mailserver.password"));
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.timeout", "25000");
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    @Bean
    public SendMail sendMail() {
        return new SendMail();
    }
}
