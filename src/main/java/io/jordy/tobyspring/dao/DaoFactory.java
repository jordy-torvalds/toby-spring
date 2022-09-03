package io.jordy.tobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao nUserDao(NConnectionMaker connectionMaker) {
        return new UserDao(connectionMaker);
    }
    @Bean
    public UserDao kUserDao(KConnectionMaker connectionMaker) {
        return new UserDao(connectionMaker);
    }
}
