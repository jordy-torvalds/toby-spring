package io.jordy.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection createConnection() throws ClassNotFoundException, SQLException;
}
