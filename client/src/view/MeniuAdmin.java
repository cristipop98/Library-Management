package view;

import server.Angajat;
import server.PersistentaAngajat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


import javax.swing .*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt .*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table .*;

public class MeniuAdmin extends JFrame {
    private JPanel menuad;
    private JPanel client;
    private JPanel sters;
    public JTable table;
    public JFrame frame3;
    private JTable tabble;
    private JTextField user;
    private JTextField parola;
    private JTextField nume;
    private JTextField prenume;
    private JTextField userSters;
    private JTextField parolaSters;
    private JTextField numeSters;
    private JTextField prenumeSters;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";
    private JButton btnBack;
    public JFrame firstPage;
    private String language;



    public MeniuAdmin() {
        connectDB();
        //initializare();
    }
    public JButton getBtnBack() {
        return btnBack;
    }

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
            con=DriverManager.getConnection(host,user1,pass);
            //JOptionPane.showMessageDialog(null,"Conectat");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Eroare la conectare SQL");

        }
    }

    public void initializare() {

        frame3 = new JFrame();
        table = new JTable();

        Object[] columns = {"Nr", "Utilizator", "Parola"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.setModel(model);

        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("", 1, 35);
        table.setFont(font);
        table.setRowHeight(60);

        JTextField textNr = new JTextField();
        JTextField textUser = new JTextField();
        JTextField textParola = new JTextField();

        JButton btnAdd = new JButton("Adaugare");
        JButton btnDelete = new JButton("Stergere");
        JButton btnUpdate = new JButton("Actualizare");
        JButton btnView = new JButton("Vizualizare");
        btnBack=new JButton("Inapoi");

        textNr.setBounds(20, 450, 120, 25);
        textUser.setBounds(20, 490, 120, 25);
        textParola.setBounds(20, 530, 120, 25);

        btnAdd.setBounds(150, 450, 100, 25);
        btnUpdate.setBounds(150, 490, 100, 25);
        btnDelete.setBounds(150, 530, 100, 25);
        btnView.setBounds(150, 570, 100, 25);
        btnBack.setBounds(300,450,100,25);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1300, 400);


        frame3.add(textUser);
        frame3.add(textParola);

        // add JButtons to the jframe
        frame3.add(btnAdd);
        frame3.add(btnDelete);
        frame3.setLayout(null);

        frame3.add(pane);

        frame3.add(textNr);
        frame3.add(btnUpdate);
        frame3.add(btnView);
        frame3.add(btnBack);

        String[] row = new String[3];

        frame3.setSize(1300,650);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);


        ArrayList<Angajat> array=new ArrayList<Angajat>();
        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String SQL1="SELECT * FROM Angajat";
                try {
                    Statement st1=con.createStatement();
                    ResultSet rs=st1.executeQuery(SQL1);
                    ResultSetMetaData rsmd=rs.getMetaData();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    int colCount=rsmd.getColumnCount();
                    int i;
                    Object[] row=new Object[6];
                    while(rs.next()) {
                        for(i=1;i<=colCount;i++) {
                            row[i-1]=rs.getObject(i);
                        }
                        model.addRow(row);
                    }
                }
                catch(Exception ex1)
                {
                    JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
                }


            }
        });

        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int x=0;
                row[0] = textNr.getText();
                row[1] = textUser.getText();
                row[2] = textParola.getText();

                x=Integer.parseInt(row[0]);

                model.addRow(row);

                Angajat p=new Angajat(x,row[1],row[2]);
                PersistentaAngajat p1=new PersistentaAngajat();
                p1.adaugareAngajat(p);


            }
        });

        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                int x=0;
                if(i >= 0){
                    // remove a row from jtable
                    row[0] = textNr.getText();
                    row[1] = textUser.getText();
                    row[2] = textParola.getText();

                    x=Integer.parseInt(row[0]);

                    Angajat a=new Angajat(x,row[0],row[1]);

                    PersistentaAngajat p=new PersistentaAngajat();
                    p.deleteAngajat(a);

                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                // i = the index of the selected row
                int i = table.getSelectedRow();
                int x=0;

                textNr.setText(model.getValueAt(i, 0).toString());
                textUser.setText(model.getValueAt(i, 1).toString());
                textParola.setText(model.getValueAt(i, 2).toString());


                row[0] = textNr.getText();
                row[1] = textUser.getText();
                row[2] = textParola.getText();





            }
        });
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                int x=0;

                if(i >= 0)
                {
                    model.setValueAt(textNr.getText(), i, 0);
                    model.setValueAt(textUser.getText(), i, 1);
                    model.setValueAt(textParola.getText(), i, 2);

                    row[0] = textNr.getText();
                    row[1] = textUser.getText();
                    row[2] = textParola.getText();

                    x=Integer.parseInt(row[0]);

                    Angajat a=new Angajat(x,row[1],row[2]);
                    PersistentaAngajat p=new PersistentaAngajat();
                    p.updateAngajat(a);
                }
                else{
                    System.out.println("Eroare la actualizare");
                }
            }
        });

        btnBack.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                frame3.setVisible(false);
                FirstPage f=new FirstPage();
                f.firstPage.setVisible(true);






            }
        });

        JComboBox combo=new JComboBox();

        combo.addItem("romana");
        combo.addItem("english");
        combo.addItem("deutsch");

        combo.setBounds(900,420,100,25);
        frame3.add(combo);

        JButton btnCombo=new JButton("Ok");
        btnCombo.setBounds(900,450,100,25);
        frame3.add(btnCombo);

        btnCombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (combo.getSelectedIndex() == 0)
                {
                    setRomana(language);
                    try {
                        Properties p = new Properties();
                        p.load(FirstPage.class.getResourceAsStream(language + ".properties"));
                        String s1=p.getProperty("btnAdaugareAdmin");
                        String s2=p.getProperty("btnStergereAdmin");
                        String s3=p.getProperty("btnActualizareAdmin");
                        String s4=p.getProperty("btnVizualizareAdmin");
                        String s5=p.getProperty("btnInapoiAdmin");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                    }
                    catch(Exception ee)
                    {
                        //  JOptionPane.showMessageDialog(this, e.getMessage());
                        System.out.println("plm");
                    }
                }
                else if (combo.getSelectedIndex() == 1)
                {
                    setEngleza(language);
                    try {
                        Properties p = new Properties();
                        p.load(FirstPage.class.getResourceAsStream(language + ".properties"));
                        String s1=p.getProperty("btnAdaugareAdmin");
                        String s2=p.getProperty("btnStergereAdmin");
                        String s3=p.getProperty("btnActualizareAdmin");
                        String s4=p.getProperty("btnVizualizareAdmin");
                        String s5=p.getProperty("btnInapoiAdmin");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                    }
                    catch(Exception ee)
                    {
                        //  JOptionPane.showMessageDialog(this, e.getMessage());
                        System.out.println("plm");
                    }
                }
                else if (combo.getSelectedIndex() == 2)
                {
                    setGermana(language);
                    try {
                        Properties p = new Properties();
                        p.load(FirstPage.class.getResourceAsStream(language + ".properties"));
                        String s1=p.getProperty("btnAdaugareAdmin");
                        String s2=p.getProperty("btnStergereAdmin");
                        String s3=p.getProperty("btnActualizareAdmin");
                        String s4=p.getProperty("btnVizualizareAdmin");
                        String s5=p.getProperty("btnInapoiAdmin");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                    }
                    catch(Exception ee)
                    {
                        //  JOptionPane.showMessageDialog(this, e.getMessage());
                        System.out.println("plm");
                    }
                }


            }
        });




    }
    public void setRomana(String language){
        this.language="romana";
    }
    public void setEngleza(String language){
        this.language="english";
    }
    public void setGermana(String language){
        this.language="deutsch";
    }
}

