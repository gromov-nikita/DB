import db.DBConnection;

import java.sql.*;
public class Runner {
    public static void main(String[] args) {
        try {
            DBConnection connection =
                    new DBConnection("root","123456", "jdbc:mysql://localhost:3306/" + "log");
            connection.pushQuery("INSERT INTO user SET login = 'Java1', password = '123456qwe', " +
                    "firstname = 'Ник', lastname = 'Гром', roleID = 1;");
            ResultSet res = connection.getQuery("select * from user");
            while(res.next()) {
                System.out.println(res.getString("UserID") + " "
                        + res.getString("firstname") + " " + res.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}