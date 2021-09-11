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
