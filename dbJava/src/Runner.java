import java.sql.*;
public class Runner {
    public static void main(String[] args) {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "log",
                            "root","123456");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("INSERT INTO app SET name = 'Java6'");
            ResultSet res = statement.executeQuery("select * from app");
            while(res.next()) {
                System.out.println(res.getString("AppID") + " " + res.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}