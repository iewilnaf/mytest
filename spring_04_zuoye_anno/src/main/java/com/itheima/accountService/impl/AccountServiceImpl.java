package com.itheima.accountService.impl;

import com.itheima.accountDao.AccountDao;
import com.itheima.accountService.AccountService;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    public void add(Account account) {

    }

    public void update(Account account) {

    }

    public void delete(Integer id) {

    }

    public Account findById(Integer id) {
        return null;
    }

    public Account findByName(String name) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }

    //转账操作
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Integer money) {

        //转出账户 减钱
        Account source = accountDao.findByName(sourceName);

        source.setMoney(source.getMoney() - money);
        accountDao.update(source);

//        int i = 1 / 0;

        //转入账户加钱
        Account target = accountDao.findByName(targetName);

        target.setMoney(target.getMoney() + money);
        accountDao.update(target);


    }


}
