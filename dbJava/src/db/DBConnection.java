package db;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import  java.util.logging.*;
public class DBConnection {
    private static Logger log = Logger.getLogger(DBConnection.class.getName());
    private Connection connection;
    private Statement statement;
    private String nameDB;
    static {
        try {
            Handler handler = new FileHandler("src/db/log/log.txt",true);
            handler.setFormatter(new SimpleFormatter());
            log.addHandler(handler);
            log.setUseParentHandlers(false);
        } catch (IOException e) {
            log.log(Level.WARNING,"File logger not working");
        }
    }
    public DBConnection(String login, String password, String url) throws SQLException {
        String[] arr = url.split("/");
        nameDB = arr[arr.length - 1];
        connection = DriverManager.getConnection(url, login, password);
        log.info(nameDB + " database. Created a connection." );
        statement = connection.createStatement();
        log.info(nameDB + " database. Created a statement.");
    }

    public void insertUser(String login, String password, String firstname,
                           String lastname, int roleID) throws SQLException {
        statement.executeUpdate("INSERT INTO user SET login = '" + login + "', password = '" + password + "', firstname = '" + firstname + "', lastname = '" + lastname + "', roleID = " + roleID);
        log.info(nameDB + " database. Query: INSERT INTO user SET login = '" + login
                + "', password = '" + password + "', firstname = '"
                + firstname + "', lastname = '" + lastname
                + "', roleID = " + roleID);
    }
    public ResultSet getUsers() throws SQLException {
        ResultSet res = statement.executeQuery("select * from user");
        log.info(nameDB + " database. Query: select * from user");
        return res;
    }
    public void closeConnection() throws SQLException {
        connection.close();
        log.info(nameDB + " database connection. Close. ");
    }
}
