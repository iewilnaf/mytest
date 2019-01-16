package com.itheima.accountService;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    public abstract void add(Account account);

    void update(Account account);

    void delete(Integer id);


    Account findById(Integer id);

    Account findByName(String name);

    List<Account> findAll();
    public void transfer(String sourceName, String targetName, Integer money);
}
