package com.nomad.test;

import com.nomad.config.BeanConfig;
import com.nomad.domain.User;
import com.nomad.service.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class SendMailTest {

    @Autowired
    SendMail sendMail;

    @Test
    public void testSendMail() {
        User user = new User("姓名", 'M', 11);
        sendMail.sendSimpleUserEmail("1635231358@qq.com", user);
    }
}
