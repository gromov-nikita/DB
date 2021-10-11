package db.tableHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class TableQueryStringMaker {
    private Class myClass;
    private Object table;
    public static String insertString(Object query) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        StringBuffer queryString = new StringBuffer("INSERT INTO ");
        queryString.append(query.getClass().getDeclaredMethod("getTableName").invoke(query));
        queryString.append(" SET ");
        stringMaker(queryString,query);
        return String.valueOf(queryString);
    }
    public static String deleteByIDString(Class myClass, int id) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, SQLException {
        StringBuffer queryString = new StringBuffer("DELETE FROM ");
        queryString.append(myClass.getDeclaredMethod("getTableName").invoke(null));
        queryString.append(" WHERE ID= ");
        queryString.append(id);
        return String.valueOf(queryString);
    }
    public static String updateByIDString(Object query, int id) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        StringBuffer queryString = new StringBuffer("UPDATE ");
        queryString.append(query.getClass().getDeclaredMethod("getTableName").invoke(query));
        queryString.append(" SET ");
        stringMaker(queryString,query);
        queryString.append(" WHERE ID = ");
        queryString.append(id);
        return String.valueOf(queryString);
    }
    public static String selectAllString(Class myClass) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        StringBuffer queryString = new StringBuffer();
        queryString.append("SELECT * FROM ");
        queryString.append(myClass.getDeclaredMethod("getTableName").invoke(null));
        return String.valueOf(queryString);
    }
    private static void stringMaker(StringBuffer str, Object table) throws IllegalAccessException {
        for(Field x : table.getClass().getDeclaredFields()) {
            x.setAccessible(true);
            if(x.getType() != String.class) {
                str.append(x.getName() + " = " +
                        x.get(table) + ", ");
            }
            else {
                str.append(x.getName() + " = '" + x.get(table) + "', ");
            }
        }
        str.delete(str.length()-2,str.length());
    }
}
