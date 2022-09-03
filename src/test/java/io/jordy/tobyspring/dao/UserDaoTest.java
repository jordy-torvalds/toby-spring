package io.jordy.tobyspring.dao;

import io.jordy.tobyspring.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserDaoTest {
    private final UserDao nUserDao;
    private final UserDao kUserDao;

    private final CountableConnectionMaker countableConnectionMaker;

    UserDaoTest(@Qualifier("nUserDao") UserDao nUserDao,
                @Qualifier("kUserDao") UserDao kUserDao,
                @Qualifier("countableNConnectionMaker") CountableConnectionMaker countableConnectionMaker) {
        this.nUserDao = nUserDao;
        this.kUserDao = kUserDao;
        this.countableConnectionMaker = countableConnectionMaker;
    }

    @Test
    void user_추가_usingNUserDao() throws SQLException, ClassNotFoundException {
        UserDao userDao = nUserDao;
        User user = new User(new Random().nextLong(), "쪼꼬미", "password");

        User addedUser = userDao.add(user);

        User selectedUser = userDao.get(addedUser.getId());
        assertEquals(addedUser, selectedUser);
    }
    @Test
    void user_추가_usingKUserDao() throws SQLException, ClassNotFoundException {
        UserDao userDao = kUserDao;
        User user = new User(new Random().nextLong(), "쪼꼬미", "password");

        User addedUser = userDao.add(user);

        User selectedUser = userDao.get(addedUser.getId());
        assertEquals(addedUser, selectedUser);
    }

    @Test
    void countableConnectionMaker() throws SQLException, ClassNotFoundException {
        int beforeCount = countableConnectionMaker.getCount();
        user_추가_usingNUserDao();
        int afterCount = countableConnectionMaker.getCount();
        assertEquals(afterCount - beforeCount, 2);
    }
}