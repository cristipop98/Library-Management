package server;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class PersistentaCarte {

    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";

    String SQL1="select * from carte where titlu=?";
    String SQL2="SELECT * FROM Carte where autor=?";
    String SQL3="SELECT * FROM Carte where domeniu=?";
    String SQL4="SELECT * FROM Carte where editura=?";
    String SQL5="SELECT * FROM Carte where disponibilitate=?";
    String SQL6="insert into carte values(?,?,?,?,?,?,?)";
    String SQL7="delete from carte where titlu=?";
    String SQL8="update carte set disponibilitate=disponibilitate-? where titlu=? and domeniu=? and editura=?";
    String SQL9="SELECT * FROM Carte where pret=?";
    String SQL10="SELECT * FROM Carte where librarie=?";
    String SQL11="update carte set titlu=?,domeniu=?,disponibilitate=?,editura=?,autor=?,pret=?,librarie=? where titlu=?";

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

    public void adaugareCarte(Carte c){
        connectDB();

        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL6);
            preparedStmt.setString (1,c.getTitlu());
            preparedStmt.setString (2,c.getDomeniu());
            preparedStmt.setInt (3, c.getDisponibilitate());
            preparedStmt.setString (4,c.getEditura());
            preparedStmt.setString (5,c.getAutor());
            preparedStmt.setFloat (6,c.getPret());
            preparedStmt.setString (7,c.getLibrarie());
            preparedStmt.execute();

        }catch(Exception ee) {
            ee.printStackTrace();
        }

    }
    public void stergereCarte(Carte c){

        connectDB();
        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL7);
            preparedStmt.setString (1,c.getTitlu());
            preparedStmt.execute();


        }catch(Exception ee) {
            ee.printStackTrace();
        }

    }

    public void updateCarte(Carte c)
    {
        connectDB();

        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL11);
            preparedStmt.setString (1,c.getTitlu());
            preparedStmt.setString (2,c.getDomeniu());
            preparedStmt.setInt (3, c.getDisponibilitate());
            preparedStmt.setString (4,c.getEditura());
            preparedStmt.setString (5,c.getAutor());
            preparedStmt.setFloat (6,c.getPret());
            preparedStmt.setString (7,c.getLibrarie());
            preparedStmt.setString (8,c.getTitlu());
            preparedStmt.execute();

        }catch(Exception ee) {
            ee.printStackTrace();
        }


    }
    public void cumparareCarte(Carte c){
        connectDB();
        try{
                PreparedStatement preparedStmt = con.prepareStatement(SQL8);
                preparedStmt.setInt(1, c.getDisponibilitate());
                preparedStmt.setString(2, c.getTitlu());
                preparedStmt.setString(3, c.getDomeniu());
                preparedStmt.setString(4, c.getEditura());
                preparedStmt.execute();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }


    public ResultSet cautareTitlu(String titlu){
        connectDB();
        ResultSet rs=null;

        try {
            PreparedStatement preparedStmt = con.prepareStatement(SQL1);
            preparedStmt.setString (1,titlu);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();

        }catch(Exception ee) {
            ee.printStackTrace();
        }
        return rs;


    }
    public ResultSet filtrareAutor(String autor){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL2);
            preparedStmt.setString(1,autor);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }
    public ResultSet filtrareDomeniu(String domeniu){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL3);
            preparedStmt.setString(1,domeniu);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }
    public ResultSet filtrareEditura(String editura){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL4);
            preparedStmt.setString(1,editura);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }

    public ResultSet filtrareDisponibilitate(int disponibilitate){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL5);
            preparedStmt.setInt(1,disponibilitate);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }

    public ResultSet filtrarePret(float pret){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL9);
            preparedStmt.setFloat(1,pret);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }

    public ResultSet filtrareLibrarie(String librarie){
        connectDB();
        ResultSet rs=null;
        try{
            PreparedStatement preparedStmt=con.prepareStatement(SQL10);
            preparedStmt.setString(1,librarie);
            preparedStmt.execute();
            rs=preparedStmt.executeQuery();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return rs;

    }

    public ArrayList<Carte> adaugareArray(ArrayList<Carte> c1)
    {
        connectDB();
        String SQL20="SELECT * FROM Carte";
        try {
            Statement st1=con.createStatement();
            ResultSet rs=st1.executeQuery(SQL20);
            ResultSetMetaData rsmd=rs.getMetaData();
            int colCount=rsmd.getColumnCount();
            int i;
            //Object[] row=new Object[7];
            while(rs.next()) {
                Carte c=new Carte();
                c.setTitlu(rs.getString("titlu"));
                c.setDomeniu(rs.getString("domeniu"));
                c.setDisponibilitate(rs.getInt("disponibilitate"));
                c.setEditura(rs.getString("editura"));
                c.setAutor(rs.getString("autor"));
                c.setPret(rs.getFloat("pret"));
                c.setLibrarie(rs.getString("librarie"));

                c1.add(c);
            }

        }
        catch(Exception ex1)
        {
            JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
        }

        return c1;
    }

}
