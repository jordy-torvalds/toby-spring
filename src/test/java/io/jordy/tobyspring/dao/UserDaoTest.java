package io.jordy.tobyspring.dao;

import io.jordy.tobyspring.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private final DaoFactory daoFactory = new DaoFactory();
    @Test
    void user_추가_usingNConnectionMaker() throws SQLException, ClassNotFoundException {
        UserDao userDao = daoFactory.kUserDao();
        User user = new User(new Random().nextLong(), "쪼꼬미", "password");

        User addedUser = userDao.add(user);

        User selectedUser = userDao.get(addedUser.getId());
        assertEquals(addedUser, selectedUser);
    }
    @Test
    void user_추가_usingKConnectionMaker() throws SQLException, ClassNotFoundException {
        UserDao userDao = daoFactory.nUserDao();
        User user = new User(new Random().nextLong(), "쪼꼬미", "password");

        User addedUser = userDao.add(user);

        User selectedUser = userDao.get(addedUser.getId());
        assertEquals(addedUser, selectedUser);
    }
}