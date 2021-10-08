package db.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import org.apache.log4j.Logger;
public class DBConnection {
    private static Logger log = Logger.getLogger(DBConnection.class.getName());
    private Connection connection;
    private String nameDB;
    private static DBConnection instance = null;

    private DBConnection(String login, String password, String url) throws SQLException {
        String[] arr = url.split("/");
        nameDB = arr[arr.length - 1];
        connection = DriverManager.getConnection(url, login, password);
        log.info(nameDB + " database. Created a connection." );
    }
    public static DBConnection getInstance(String login, String password, String url) throws SQLException {
        if(instance == null) {
            instance = new DBConnection(login,password,url);
        }
        return instance;
    }
    public String getNameDB() {
        return nameDB;
    }
    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        if(connection != null) {
            connection.close();
            connection = null;
            log.info(nameDB + " database connection. Close. ");
        }
    }
}