package db.tables;

public class User implements IQueryTable {
    public static final String tableName = "User";
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
    @Override
    public String getTableName() {
        return tableName;
    }

    public static String getDeleteByIDStr() {
        return "DELETE FROM " + tableName + " WHERE UserID=";
    }

    @Override
    public String getUpdateByIDStr() {
        return "UPDATE " + tableName + " SET username = '" + username + "', password = '" + password
                + "', firstname = '" + firstname + "', lastname = '"
                + lastname + "' WHERE UserID=";
    }

    @Override
    public String getInsertStr() {
        return "username = '" + username + "', password = '" + password
                + "', firstname = '" + firstname + "', lastname = '"
                + lastname + "'";
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
