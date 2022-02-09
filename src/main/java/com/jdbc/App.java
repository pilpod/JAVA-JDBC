package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

            System.out.println("Adding a Dog");
            mysql.executeUpdate("INSERT INTO dogs (name,breed) VALUES ('Max','Pastor Aleman')");
            
            // Retrieve all dogs
            ResultSet data = mysql.executeQuery("SELECT * FROM dogs");

            while (data.next()) {
                System.out.println(data.getString("name"));
            }

            
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }

    }
}
