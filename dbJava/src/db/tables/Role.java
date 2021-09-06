package db.tables;

public class Role implements IQuery{
    private static final String tableName = "role";
    private String name;
    public Role(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String insert() {
        return "name = '" + name + "'";
    }

    @Override
    public String getTableName() {
        return tableName;
    }

}
