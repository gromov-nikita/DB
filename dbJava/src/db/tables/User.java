package db.tables;

public class User implements IQuery {
    public static final String tableName = "User";
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private int roleID;
    public User(String login, String password, String firstName, String lastName, int roleID) {
        this.login = login;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.roleID = roleID;
    }
    public String getLogin() {
        return login;
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
    public int getRoleID() {
        return roleID;
    }
    @Override
    public String getTableName() {
        return tableName;
    }
    @Override
    public String insert() {
        return "login = '" + login + "', password = '" + password
                + "', firstname = '" + firstname + "', lastname = '"
                + lastname + "', roleID = " + roleID;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}
