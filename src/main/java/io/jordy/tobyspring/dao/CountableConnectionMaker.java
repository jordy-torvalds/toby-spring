package io.jordy.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class CountableConnectionMaker implements ConnectionMaker {
    private int count = 0;
    private final ConnectionMaker connectionMaker;

    public CountableConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    @Override
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        count++;
        return connectionMaker.createConnection();
    }

    public int getCount() {
        return count;
    }
}
