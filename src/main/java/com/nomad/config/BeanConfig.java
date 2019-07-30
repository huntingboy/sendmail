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
        //或者使用placeholder...+@value(${})获取属性
        //或者spring el : @value(#{})获取属性
        mailSender.setHost(environment.getProperty("mailserver.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("mailserver.port")));
        mailSender.setUsername(environment.getProperty("mailserver.username"));
        mailSender.setPassword(environment.getProperty("mailserver.password"));
        mailSender.setDefaultEncoding(environment.getProperty("mailserver.default-encoding"));
        mailSender.setProtocol(environment.getProperty("mailserver.protocol"));

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.timeout", "25000");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

    @Bean
    public SendMail sendMail() {
        return new SendMail();
    }
}
