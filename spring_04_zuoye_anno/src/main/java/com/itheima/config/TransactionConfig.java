package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//和事务相关的配置类

public class TransactionConfig {


    //用于创建事务管理器对象
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransaction(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
}
