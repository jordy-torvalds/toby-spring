package io.jordy.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class KUserDao extends UserDao{
    private final ConnectionMaker connectionMaker;
    public KUserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    protected Connection createConnection() throws SQLException, ClassNotFoundException {
        return connectionMaker.createConnection();
    }
}
