package io.jordy.tobyspring.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public ConnectionMaker countableNConnectionMaker(NConnectionMaker nConnectionMaker) {
        return new CountableConnectionMaker(nConnectionMaker);
    }

    @Bean
    public ConnectionMaker countableKConnectionMaker(KConnectionMaker kConnectionMaker) {
        return new CountableConnectionMaker(kConnectionMaker);
    }
    @Bean
    public UserDao nUserDao(@Qualifier("countableNConnectionMaker") ConnectionMaker connectionMaker) {
        return new UserDao(connectionMaker);
    }
    @Bean
    public UserDao kUserDao(@Qualifier("countableKConnectionMaker") ConnectionMaker connectionMaker) {
        return new UserDao(connectionMaker);
    }
}
