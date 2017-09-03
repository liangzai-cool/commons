package org.xueliang.commons.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao implements Closeable {

    private String URL = "";
    private String DRIVER = "";
    private String USER = "";
    private String PASSWORD = "";

    private Connection connection;

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            synchronized (BaseDao.class) {
                if (connection == null) {
                    Class.forName(DRIVER);
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            }
        }
        return connection;
    }

    public void loadProperties(Properties properties) {
        URL = properties.getProperty("jdbc.url");
        DRIVER = properties.getProperty("jdbc.driverClassName");
        USER = properties.getProperty("jdbc.username");
        PASSWORD = properties.getProperty("jdbc.password");
    }

    @Override
    public void close() throws IOException {
        close(connection, null, null);
    }
    
    public void close(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            
        }
    }
}
