package org.academiadecodigo.hackathon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon?useSSL=false");
            System.out.println(connection.isClosed());
         } catch (SQLException ex){

        }
    }
}
