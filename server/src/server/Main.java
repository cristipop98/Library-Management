package server;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private Connection con;
    private Connection mystObj;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";
    public static void main(String[] args) {
        Server server = new Server(5000);


    }

}
