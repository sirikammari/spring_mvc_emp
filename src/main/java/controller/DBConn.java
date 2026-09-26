package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    public static Connection getConn() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/emsdb",
                "root",
                "password"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}