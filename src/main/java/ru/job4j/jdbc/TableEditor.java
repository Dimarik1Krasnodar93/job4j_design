package ru.job4j.jdbc;

import javax.management.remote.TargetedNotification;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Statement st;

    public TableEditor(Properties properties) {
        initConnection(properties);
    }

    private void initConnection(Properties properties) {
        try {
            connection = DriverManager.getConnection(properties.get("url").toString(), properties);
            st = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createTable(String tableName) {
        try {
            var res = st.execute(String.format("create table %s (id serial primary key)", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try {
            var res = st.executeUpdate(String.format("drop table %s", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try {
            var res = st.executeUpdate(String.format("alter table %s add column %s %s", tableName, columnName, type));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try {
            var res = st.executeUpdate(String.format("alter table %s drop column %s", tableName, columnName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try {
            var res = st.executeUpdate(String.format("alter table %s rename %s to %s", tableName, columnName, newColumnName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
        if (st != null) {
            st.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties prs = new Properties();
        final ClassLoader classLoader = TableEditor.class.getClassLoader();
        try (InputStream io = classLoader.getResourceAsStream("app.properties")) {
            prs.load(io);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (TableEditor te = new TableEditor(prs)) {
            String tableName = "t" + System.currentTimeMillis();
            te.createTable(tableName);
            System.out.println(getTableScheme(te.connection, tableName));
            te.addColumn(tableName, "name", "text");
            System.out.println(getTableScheme(te.connection, tableName));
            te.renameColumn(tableName, "name", "newname");
            System.out.println(getTableScheme(te.connection, tableName));
            te.dropColumn(tableName, "newname");
            System.out.println(getTableScheme(te.connection, tableName));
            te.dropTable(tableName);
            try {
                System.out.println(getTableScheme(te.connection, tableName));
            } catch (SQLException ex) {
                System.out.println("Table has been already deleted");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
