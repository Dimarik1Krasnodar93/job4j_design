package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private final Properties prs =  new Properties();
    private String url;
    private String login;
    private String password;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionDemo demo = new ConnectionDemo();
        demo.loadProperties();
        demo.getConnection();
    }

    public void getConnection() {
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties() {
        final ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            prs.load(io);
            url = prs.get("url").toString();
            login = prs.get("login").toString();
            password = prs.get("password").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
