import control.Card;
import control.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    public static Connection connection = null;

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM users";
            System.out.println("users:");
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getLong("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
                System.out.println(resultSet.getLong("user_id") + " " + resultSet.getString("login") + " " + resultSet.getString("password") + " " + resultSet.getString("role"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

    }

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8", "root", "root");
        if (connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connected");
        }
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }
}
