package db;

import db.connection.DBConnection;
import db.tables.IQuery;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;


public class Queries {
    private DBConnection connection;
    private Statement statement;
    private static Logger logQ = Logger.getLogger(Queries.class.getName());
    static {
        try {
            Handler handler = new FileHandler("src/db/log/logQuery.txt",true);
            handler.setFormatter(new SimpleFormatter());
            logQ.addHandler(handler);
            logQ.setUseParentHandlers(false);
        } catch (IOException e) {
            logQ.log(Level.WARNING,"File logger not working");
        }
    }
    public Queries(DBConnection connection) throws SQLException {
        this.connection = connection;
        statement = connection.getConnection().createStatement();
        logQ.info(connection.getNameDB() + " database. Created a statement.");
    }
    public void insert(IQuery query) throws SQLException {
        logQ.info(connection.getNameDB() + "INSERT INTO  + query.getTableName() +  SET  + query.insert()");
        statement.executeUpdate("INSERT INTO " + query.getTableName() + " SET " + query.insert());
    }
    public ResultSet selectAll(String tableName) throws SQLException {
        logQ.info(connection.getNameDB() + " Select all from " + tableName );
        return statement.executeQuery("SELECT * " + "FROM " + tableName);
    }
}
