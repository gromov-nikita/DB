
import db.Queries;
import db.connection.DBConnection;
import db.tableHandler.TableQueryStringMaker;
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
            reader = new FileReader("src/main/resources/connection.properties");
            properties.load(reader);
            connection = DBConnection.getInstance(properties.getProperty("login"),
                    properties.getProperty("password"),
                    properties.getProperty("url"));
            Queries queries = new Queries(connection);


            System.out.println("\n\nUSER\n\n");
            User user1 = new User("MyNewGrom12","12345","n4","n4");
            //queries.push(TableQueryStringMaker.insertString(user1));
            //queries.push(TableQueryStringMaker.deleteByIDString(User.class,15));
            //queries.push(TableQueryStringMaker.updateByIDString(user1, 17));
            List<User> res1 = queries.pull(TableQueryStringMaker.selectAllString(User.class),User.class);
            for(User x : res1) {
                System.out.println(x.toString());
            }


            System.out.println("\n\nPERMISSIONS\n\n");
            Permissions permissions1 = new Permissions("MyNewGrom2");
            //queries.push(TableQueryStringMaker.insertString(permissions1));
            //queries.push(TableQueryStringMaker.deleteByIDString(Permissions.class,5));
            //queries.push(TableQueryStringMaker.updateByIDString(permissions1, 8));
            List<Permissions> res2 = queries.pull(TableQueryStringMaker.selectAllString(Permissions.class),
                    Permissions.class);
            for(Permissions x : res2) {
                System.out.println(x.toString());
            }

            System.out.println("\n\nROLE\n\n");
            Role role1 = new Role("MyNewGrom6");
            //queries.push(TableQueryStringMaker.insertString(role1));
            //queries.push(TableQueryStringMaker.deleteByIDString(Role.class,7));
            //queries.push(TableQueryStringMaker.updateByIDString(role1,8));
            List<Role> res3 = queries.pull(TableQueryStringMaker.selectAllString(Role.class),Role.class);
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
