package io.jordy.tobyspring.dao;

import io.jordy.tobyspring.domain.User;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class UserDao {
    private final ConnectionMaker connectionMaker;
    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public User add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.createConnection();

        PreparedStatement preparedStatement
                = connection.prepareStatement("insert into user(id, name, password) values(?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

        return user;
    }
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.createConnection();

        PreparedStatement preparedStatement
                = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }
}
