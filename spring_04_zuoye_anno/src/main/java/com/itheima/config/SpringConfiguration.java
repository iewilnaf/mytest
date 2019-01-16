package com.itheima.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("classpath:druid.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
