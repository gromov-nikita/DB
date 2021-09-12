package db;

import db.connection.DBConnection;
import db.tables.IQuery;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
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
        logQ.info(connection.getNameDB() + "INSERT INTO " + query.getTableName() + " SET " + query.insert());
        statement.executeUpdate("INSERT INTO " + query.getTableName() + " SET " + query.insert());
    }
    public void deleteByID(Class myClass, int id) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, SQLException {
        logQ.info(connection.getNameDB() +
                (String)myClass.getDeclaredMethod("deleteByID").invoke(null) + id);
        statement.executeUpdate((String)myClass.getDeclaredMethod("deleteByID").invoke(null) + id);
    }
    public void updateByID(IQuery query, int id) throws SQLException {
        logQ.info(connection.getNameDB() +
                query.updateByID() + id);
        statement.executeUpdate(query.updateByID() + id);
    }
    public List selectAll(Class myClass) throws SQLException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        logQ.info(connection.getNameDB() + " Select all from " +
                myClass.getDeclaredField("tableName").get(new String()));
        ResultSet res = statement.executeQuery("SELECT * " + "FROM " +
                myClass.getDeclaredField("tableName").get(new String()));
        List list = new LinkedList();
        Field[] fields = myClass.getDeclaredFields();
        Constructor constructor = myClass.getDeclaredConstructors()[0];
        Object[] objects = new Object[fields.length-1];
        while(res.next()) {
            for (int i = 0; i < objects.length; i++) {
                objects[i] = res.getObject(fields[i+1].getName());
            }
            list.add(constructor.newInstance(objects));

        }
        return list;
    }
}
