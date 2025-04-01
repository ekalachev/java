package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLInsertExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "eldar";
        String password = "eldar";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS people (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "age INT)";
            stmt.executeUpdate(createTable);

            String insert1 = "INSERT INTO people (name, age) VALUES ('Charlie', 28)";
            String insert2 = "INSERT INTO people (name, age) VALUES ('Diana', 22)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);

            System.out.println("Data inserted into MySQL!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
