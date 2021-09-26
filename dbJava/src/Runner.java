
import db.Queries;
import db.connection.DBConnection;
import db.tables.Permissions;
import db.tables.Role;
import db.tables.User;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;
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
            User user1 = new User("i2","12345","i2","i2");
            queries.insert(user1);
            //queries.deleteByID(User.class,3);
            //queries.updateByID(user1, 2);
            List<User> res1 = queries.selectAll(User.class);
            for(User x : res1) {
                System.out.println(x.toString());
            }


            System.out.println("\n\nPERMISSIONS\n\n");
            Permissions permissions1 = new Permissions("i2");
            queries.insert(permissions1);
            //queries.deleteByID(Permissions.class,3);
            //queries.updateByID(permissions1, 2);
            List<Permissions> res2 = queries.selectAll(Permissions.class);
            for(Permissions x : res2) {
                System.out.println(x.toString());
            }

            System.out.println("\n\nROLE\n\n");
            Role role1 = new Role("i2");
            queries.insert(role1);
            //queries.deleteByID(Role.class,6);
            //queries.updateByID(role1,5);
            List<Role> res3 = queries.selectAll(Role.class);
            for(Role x : res3) {
                System.out.println(x.toString());
            }

        }
        catch (IOException ex) {
            System.out.println("Property file: not found");
            ex.printStackTrace();
        }
        catch (SQLException ex) {
            System.out.println("SqlException");
            ex.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
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