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

    private Properties properties;

    public TableEditor() {

    }

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        Properties prs = loadProperties();
        try {
            connection = DriverManager.getConnection(prs.get("url").toString(), prs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Properties loadProperties() {
        Properties prs = new Properties();
        final ClassLoader classLoader = TableEditor.class.getClassLoader();
        try (InputStream io = classLoader.getResourceAsStream("app.properties")) {
            prs.load(io);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prs;
    }

    public void createTable(String tableName) {
        try (Statement st = connection.createStatement()) {
            var res = st.execute(String.format("create table %s (id serial primary key)", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try (Statement st = connection.createStatement()) {
            var res = st.executeUpdate(String.format("drop table %s", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (Statement st = connection.createStatement()) {
            var res = st.executeUpdate(String.format("alter table %s add column %s %s", tableName, columnName, type));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement st = connection.createStatement()) {
            var res = st.executeUpdate(String.format("alter table %s drop column %s", tableName, columnName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement st = connection.createStatement()) {
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
    }

    public static void main(String[] args) throws Exception {
        TableEditor te = new TableEditor();
        te.initConnection();
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
        System.out.println(getTableScheme(te.connection, tableName));
    }
}
