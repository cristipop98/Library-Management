package server;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PersistentaAngajat {

    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";

    String SQL1="SELECT * FROM Angajat";
    String SQL2="insert into angajat values(?,?,?)";
    String SQL3="delete from angajat where id=?";
    String SQL4="update angajat set utilizator=?,parola=? where id=?";


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

    public void adaugareAngajat(Angajat a){
        connectDB();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL2);
            preparedStmt.setInt (1, a.getNr());
            preparedStmt.setString (2, a.getUser());
            preparedStmt.setString (3, a.getParola());
            preparedStmt.execute();

        }catch(Exception ee) {
            ee.printStackTrace();
        }
    }

    public void deleteAngajat(Angajat a){
        connectDB();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL3);
            preparedStmt.setInt (1, a.getNr());
            preparedStmt.execute();

        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public void updateAngajat(Angajat a){
        connectDB();

        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL4);
            preparedStmt.setString (1, a.getUser());
            preparedStmt.setString (2, a.getParola());
            preparedStmt.setInt (3, a.getNr());
            preparedStmt.execute();

        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public ArrayList adaugareArray(ArrayList<Angajat> a)
    {
        connectDB();
        SQL1="select * from angajat";

        try{
            Statement st1=con.createStatement();
            ResultSet rs=st1.executeQuery(SQL1);
            ResultSetMetaData rsmd=rs.getMetaData();
            while(rs.next()) {
                Angajat a1 = new Angajat();
                a1.setNr(rs.getInt("id"));
                a1.setUser(rs.getString("utilizator"));
                a1.setParola(rs.getString("parola"));

                a.add(a1);

            }
        }catch(Exception ex1){
            JOptionPane.showMessageDialog(null,"Eroare de vizualizare");

        }
        return a;
    }
}
