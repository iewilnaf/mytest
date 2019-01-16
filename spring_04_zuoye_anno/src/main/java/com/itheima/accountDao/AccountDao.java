package com.itheima.accountDao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {

    public abstract void add(Account account);

    void update(Account account);

    void delete(Integer id);


    Account findById(Integer id);

    Account findByName(String name);

    List<Account> findAll();



}
