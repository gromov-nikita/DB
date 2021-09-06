
import db.Queries;
import db.connection.DBConnection;
import db.tables.Permissions;
import db.tables.Role;
import db.tables.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        Properties properties = new Properties();
        DBConnection connection = null;
        FileReader reader = null;
        try {
            reader = new FileReader("src/db/connection/connection.properties");
            properties.load(reader);
            connection = new DBConnection(properties.getProperty("login"),
                    properties.getProperty("password"),
                    properties.getProperty("url"));
            Queries queries = new Queries(connection);


            System.out.println("\n\nUSER\n\n");
            User user1 = new User("hrom10","12345","Ники","Громи", 2);
            queries.insert(user1);
            ResultSet res = queries.selectAll("User");
            while(res.next()) {
                System.out.println(res.getString("login") + " "
                        + res.getString("firstname") + " "
                        + res.getString("UserID"));
            }


            System.out.println("\n\nPERMISSIONS\n\n");
            Permissions permissions1 = new Permissions("do smth3", 3);
            queries.insert(permissions1);
            res = queries.selectAll("permissions");
            while(res.next()) {
                System.out.println(res.getString("name") + " "
                        + res.getString("roleID"));
            }

            System.out.println("\n\nROLE\n\n");
            Role role1 = new Role("worker2");
            queries.insert(role1);
            res = queries.selectAll("role");
            while(res.next()) {
                System.out.println(res.getString("name") + " "
                        + res.getString("roleID"));
            }

        }
        catch (IOException ex) {
            System.out.println("Property file: not found");
            ex.printStackTrace();
        }
        catch (SQLException ex) {
            System.out.println("SqlException");
            ex.printStackTrace();
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}