import java.sql.*;
public class Runner {
    public static void main(String[] args) {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "log",
                            "root","123456");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("INSERT INTO user SET login = 'Java1', password = '123456qwe', " +
                    "firstname = 'Ник', lastname = 'Гром', role = 'ADMIN';");
            ResultSet res = statement.executeQuery("select * from user");
            while(res.next()) {
                System.out.println(res.getString("UserID") + " "
                        + res.getString("firstname") + " " + res.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}