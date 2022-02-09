package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        try {

            String table = "java_tests_jdbc";

            String url = "jdbc:mysql://localhost:3306/" + table + "?useSSL=false"; // or jdbc:mysql://@localhost:3306/java_tests_jdbc
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfull");

            Statement mysql = connection.createStatement();

            // Deleting data in database
            deleteDog(mysql);

            // Adding data in database
            System.out.println("Adding a Dog");
            addDog(mysql);

            // Update data in database
            updateDog(mysql);
            
            // Retrieve all dogs
            ResultSet data = mysql.executeQuery("SELECT * FROM dogs");

            while (data.next()) {
                System.out.println(data.getString("name"));
            }

            connection.close();
            
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }

    }

    public static void addDog(Statement mysql) throws SQLException {
        mysql.executeUpdate("INSERT INTO dogs (name,breed) VALUES ('Bilbo','Pastor Aleman')");
    }

    public static void updateDog(Statement mysql) throws SQLException {
        mysql.executeUpdate("UPDATE dogs SET name = 'SuperDog' WHERE name = 'Bilbo'");
    }

    public static void deleteDog(Statement mysql) throws SQLException {
        mysql.executeUpdate("DELETE FROM dogs WHERE name = 'SuperDog'");
    }
}
