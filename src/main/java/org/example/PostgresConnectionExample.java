package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgresConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/users";
        String user = "eldar";
        String password = "eldar";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS people (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "age INT)";
            stmt.executeUpdate(createTable);

            String insert1 = "INSERT INTO people (name, age) VALUES ('Alice', 30)";
            String insert2 = "INSERT INTO people (name, age) VALUES ('Bob', 25)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}