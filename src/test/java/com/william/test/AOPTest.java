package com.william.test;

import com.william.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
        IAccountService accountService = (IAccountService)ac.getBean("accountService");

        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deleteAccount();
    }
}
