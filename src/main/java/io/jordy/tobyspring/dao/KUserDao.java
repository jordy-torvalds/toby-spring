package io.jordy.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class KUserDao extends UserDao{

    protected Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getConnection("jdbc:mysql://localhost:3306/default",
                "root",
                "password");
    }
}
