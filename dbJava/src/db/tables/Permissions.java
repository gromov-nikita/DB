package db.tables;

public class Permissions implements IQueryTable {
    public static final String tableName = "permissions";
    private String name;
    public Permissions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String getTableName() {
        return tableName;
    }

    public static String getDeleteByIDStr() {
        return "DELETE FROM " + tableName + " WHERE permissionID=";
    }

    @Override
    public String getUpdateByIDStr() {
        return "UPDATE " + tableName + " SET name = '" + name + "' WHERE permissionID=";
    }

    @Override
    public String getInsertStr() {
        return "name = '" + name + "'";
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "name='" + name + '\'' +
                '}';
    }
}
