package db.tables;

public class Role implements IQuery{
    public static final String tableName = "role";
    private String name;
    public Role(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String getTableName() {
        return tableName;
    }

    public static String deleteByID() {
        return "DELETE FROM " + tableName + " WHERE roleID=";
    }

    @Override
    public String updateByID() {
        return "UPDATE " + tableName + " SET name = '" + name + "' WHERE roleID=";
    }

    @Override
    public String insert() {
        return "name = '" + name + "'";
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
