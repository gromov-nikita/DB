package db.tables;

public class Permissions implements IQuery {
    private static final String tableName = "permissions";
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
    public String insert() {
        return "name = '" + name + "', roleID = " + roleID;
    }

    @Override
    public String getTableName() {
        return tableName;
    }
}
