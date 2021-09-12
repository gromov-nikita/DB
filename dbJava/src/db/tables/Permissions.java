package db.tables;

public class Permissions implements IQuery {
    public static final String tableName = "permissions";
    private String name;
    private int roleID;
    public Permissions(String name, int roleID) {
        this.name = name;
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }
    public int getRoleID() {
        return roleID;
    }
    @Override
    public String getTableName() {
        return tableName;
    }

    public static String deleteByID() {
        return "DELETE FROM " + tableName + " WHERE permissionID=";
    }

    @Override
    public String updateByID() {
        return "UPDATE " + tableName + " SET name = '" + name + "', roleID = " + roleID + " WHERE permissionID=";
    }

    @Override
    public String insert() {
        return "name = '" + name + "', roleID = " + roleID;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "name='" + name + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}
