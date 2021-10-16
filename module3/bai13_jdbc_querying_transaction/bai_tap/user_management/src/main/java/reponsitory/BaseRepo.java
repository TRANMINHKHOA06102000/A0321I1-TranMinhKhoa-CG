package reponsitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_jdbc";
    private String jdbcUsername = "root";
    private String jdbcPassword = "khoa4755@gmail";

    public BaseRepo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
