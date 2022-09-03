package io.jordy.tobyspring.dao;

import io.jordy.tobyspring.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class NUserDao extends UserDao{

    protected Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getConnection("jdbc:mysql://localhost:3306/default",
                "root",
                "password");
    }
}
