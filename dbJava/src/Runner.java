import db.DBConnection;

import java.sql.*;
public class Runner {
    public static void main(String[] args) {
        try {
            DBConnection connection =
                    new DBConnection("root","123456", "jdbc:mysql://localhost:3306/" + "log");
            connection.insertUser( "Java18","123456qwe",
                    "Никита", "Громов", 1);
            ResultSet res = connection.getUsers();
            while(res.next()) {
                System.out.println(res.getString("UserID") + " "
                        + res.getString("firstname") + " " + res.getString("lastname"));
            }
            connection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}