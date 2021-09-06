package db.tables;

public class User implements IQuery {
    private static final String tableName = "User";
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int roleID;
    public User(String login, String password, String firstName, String lastName, int roleID) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getRoleID() {
        return roleID;
    }

    @Override
    public String insert() {
        return "login = '" + login + "', password = '" + password
                + "', firstname = '" + firstName + "', lastname = '"
                + lastName + "', roleID = " + roleID;
    }

    @Override
    public String getTableName() {
        return tableName;
    }
}
