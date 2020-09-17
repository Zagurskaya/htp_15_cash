package com.gmail.zagurskaya.dao;

import com.gmail.zagurskaya.exception.DataBaseConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    static final Logger logger = LogManager.getLogger(AbstractDao.class);
    protected Connection connection = null;


    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Database exception during connection", e);
                throw new DataBaseConnectionException("Database exception during connection", e);
            }
        }
    }

    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Database exception during connection", e);
                throw new DataBaseConnectionException("Database exception during connection", e);
            }
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}