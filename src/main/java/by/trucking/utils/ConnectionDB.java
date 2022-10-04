package by.trucking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
        private static final String URL = "jdbc:mysql://localhost:3306/trucking";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        private static Connection connection;

        private ConnectionDB() {}

        public static Connection getConnect() {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;

    }
}
