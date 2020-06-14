package server;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PersistentaAdmin {

    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";

    public void connectDB() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Eroare la conectare");
        }
        con=null;
        try {
            con= DriverManager.getConnection(host,user1,pass);
            //JOptionPane.showMessageDialog(null,"Conectat");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Eroare la conectare SQL");

        }
    }


    public ArrayList adaugareArray(ArrayList<Admin> a)
    {
        connectDB();
        String SQL1="select * from administrator";
        try{
            Admin a1=new Admin();
            System.out.println("ceva1");
            Statement st1=con.createStatement();
            ResultSet rs=st1.executeQuery(SQL1);
            ResultSetMetaData rsmd=rs.getMetaData();
            System.out.println("ceva3");
            while(rs.next()) {
                a1.setUser(rs.getString("utilizator"));
                a1.setParola(rs.getString("parola"));
                System.out.println("ceva1");

                a.add(a1);
            }
            System.out.println("ceva2");
        }catch(Exception ex1){
            JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
        }

        return a;
    }
}
