package db.tables;

public interface IQueryTable {
    String getInsertStr();
    String getTableName();
    String getUpdateByIDStr();
}
