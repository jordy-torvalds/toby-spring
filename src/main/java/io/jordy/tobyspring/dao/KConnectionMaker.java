package io.jordy.tobyspring.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

@Component
public class KConnectionMaker implements ConnectionMaker {
    @Override
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getConnection("jdbc:mysql://localhost:3306/default",
                "root",
                "password");
    }

}
