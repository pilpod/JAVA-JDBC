package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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

            PreparedStatement mysql = connection.prepareStatement("SELECT * FROM dogs WHERE breed=?");
            mysql.setString(1, "Pastor Aleman");
            
            // Retrieve all dogs
            ResultSet data = mysql.executeQuery(); // If prepareStatement is to store,update or delete need use executeUpdate();

            while (data.next()) {
                System.out.println(data.getString("name"));
            }

            connection.close();
            
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }

    }
}
