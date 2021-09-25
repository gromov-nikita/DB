package db.tables;

public class Permissions implements IQueryTable {
    private String name;
    public Permissions(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static String getTableName() {
        return "permissions";
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "name='" + name + '\'' +
                '}';
    }
}
