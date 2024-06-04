package com.fernandogbs.conn;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public final String URL = "jdbc:sqlite:database";

    public void verifyConnection(){
        try (var conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
