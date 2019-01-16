package com.itheima.accountDao.impl;

import com.itheima.accountDao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Account account) {
        String sql = "insert into account(null,?,?)";
        jdbcTemplate.update(sql,account.getUsername(),account.getMoney());

    }

    public void update(Account account) {
        String  sql = "update account set username = ? , money =? where id = ?";
        jdbcTemplate.update(sql,account.getUsername(),account.getMoney(),account.getId());

    }

    public void delete(Integer id) {
        String sql= "delete from account where id=?";
        jdbcTemplate.update(sql);

    }

    public Account findById(Integer id) {
        String sql = "select * from account where id= ?";
        Account account = null;
        try {
            account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account findByName(String name) {
        String sql= "select * from account where username = ?";
        Account account = null;
        try {
            account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> findAll() {
        String sql = " select * from account";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }
}
