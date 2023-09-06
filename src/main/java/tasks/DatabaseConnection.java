package tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost/bbb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1111";

    /**
     * Establishes a database connection using the provided database URL, username, and password.
     *
     * @return A {@link java.sql.Connection} object representing the database connection.
     * @throws SQLException If a database access error occurs or the URL, username, or password is invalid.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
