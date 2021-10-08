package db.tables;

public class Role {
    private String name;
    public Role(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static String getTableName() {
        return "role";
    }
    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
