package com.demo.feb_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConf {

    public static Connection getMyDatabaseConnection() {
        Connection cn = null;
        String url = "jdbc:mysql://localhost:3306/upi";
        String id = "root";
        String pass = "Pr@4875";

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully...");

            // Establish Connection
            cn = DriverManager.getConnection(url, id, pass);
            System.out.println("Connection Established Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("🚨 JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("🚨 Database Connection Failed!");
            e.printStackTrace();
        }
        return cn;
    }

//    public static void main(String[] args) {
//        Connection testConn = getMyDatabaseConnection();
//        if (testConn == null) {
//            System.out.println(" Database connection is NULL!");
//        }
//    }
}
