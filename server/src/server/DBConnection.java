package server;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public static void main(String[] args) {

        try {
            String host = "jdbc:mysql://localhost:3306/librarie";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(host, user, pass);
            Statement st1 = con.createStatement();
            JOptionPane.showMessageDialog(null, "Conectare reusita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }

    }
}
