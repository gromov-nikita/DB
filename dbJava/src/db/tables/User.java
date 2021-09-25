package db.tables;

public class User implements IQueryTable {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
    }
    public String getLogin() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public static String getTableName() {
        return "User";
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname +
                '}';
    }
}
