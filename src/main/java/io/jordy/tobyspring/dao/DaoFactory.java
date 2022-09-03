package io.jordy.tobyspring.dao;

public class DaoFactory {
    public UserDao nUserDao() {
        return new UserDao(new NConnectionMaker());
    }
    public UserDao kUserDao() {
        return new UserDao(new KConnectionMaker());
    }
}
