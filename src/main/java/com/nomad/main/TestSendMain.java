package com.nomad.main;

import com.nomad.config.BeanConfig;
import com.nomad.domain.User;
import com.nomad.service.SendMail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSendMain {

    /*public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        User user = new User("姓名", 'M', 11);

        ((SendMail)context.getBean("sendMail")).sendSimpleUserEmail("1635231358@qq.com", user);
    }*/
}
