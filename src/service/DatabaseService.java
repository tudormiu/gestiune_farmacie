package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static DatabaseService instance;
    private Connection connection;

    private DatabaseService() {
        try {
            String URL = "jdbc:oracle:thin:@localhost:1522:xe";
            String USERNAME = "c##pao";
            String PASSWORD = "27042003";
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}