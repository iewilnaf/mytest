package com.itheima.accountService.impl;

import com.itheima.accountService.AccountService;
import com.itheima.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = SpringConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("zhangsan","lisi",100);


    }
}