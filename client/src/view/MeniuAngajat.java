package view;

import controller.*;
import server.Carte;
import server.PersistentaCarte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.TextUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
public class MeniuAngajat extends JFrame{
    private JFrame frameA;
    private JTable table;
    private JFrame frame3;
    private JScrollPane scrollPane1;
    private JButton backButton;
    private int d;
    private String e;
    private float p;
    private String a;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/librarie";
    private String user1 = "root";
    private String pass = "";
    private String english="english";
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnView;
    private JButton btncautareTitlu;
    private JButton btnFiltrareDisponibilitate;
    private JButton btnFiltrarePret;
    private JButton btnFiltrareAutor;
    private JButton btnFiltrareDomeniu;
    private JButton btnFiltrareEditura;
    private JButton btnCumparare;
    private JButton btnRaport;
    private JButton btnLibrarie;
    private JButton btnBack;
    private String language;
    private ArrayList<IObserver> observers=new ArrayList<>();
    private IObserver obs;

    public MeniuAngajat() {
        connectDB();
        initializare();

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
            con= DriverManager.getConnection(host,user1,pass);
            //JOptionPane.showMessageDialog(null,"Conectat");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Eroare la conectare SQL");

        }
    }
    public void initializare(){
        frame3 = new JFrame();
        table = new JTable();



        Object[] columns = {"Titlu", "Domeniu", "Disponibilitate", "Editura", "Autor", "Pret","Librarie"};
        Object[] columns1={"Title", "Field", "Availability", "Publishing house", "Writer", "Price","Library"};
        Object[] columns2={"Titel", "Feld", "Verfügbarkeit", "Verlagswesen", "Autor", "Preis","Buchhandlung"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.setModel(model);

        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("", 1, 22);
        table.setFont(font);
        table.setRowHeight(30);

        JTextField textTitlu = new JTextField();
        JTextField textDomeniu = new JTextField();
        JTextField textDisponibilitate = new JTextField();
        JTextField textEditura = new JTextField();
        JTextField textAutor = new JTextField();
        JTextField textPret = new JTextField();
        JTextField textLibrarie=new JTextField();
        JTextField textCautareTitlu = new JTextField();
        JTextField textFiltrareAutor = new JTextField();
        JTextField textFiltrareDomeniu = new JTextField();
        JTextField textFiltrareEditura = new JTextField();
        JTextField textFiltrarePret = new JTextField();
        JTextField textFiltrareDisponibilitate = new JTextField();
        JTextField textFiltrareLibrarie=new JTextField();
        JTextField textceva=new JTextField();

        btnAdd = new JButton("Adaugare");
        btnDelete = new JButton("Stergere");
        btnUpdate = new JButton("Actualizare");
        btnView = new JButton("Vizualizare");
        btncautareTitlu = new JButton("Cautare titlu");
        btnFiltrareDisponibilitate = new JButton("Filtrare disp.");
        btnFiltrarePret = new JButton("Filtrare pret");
        btnFiltrareAutor = new JButton("Filtrare autor");
        btnFiltrareDomeniu = new JButton("Filtrare domeniu");
        btnFiltrareEditura = new JButton("Filtrare editura");
        btnCumparare = new JButton("Cumpara");
        btnRaport = new JButton("Rapoarte");
        btnLibrarie=new JButton("Filtrare librarie");
        btnBack=new JButton("Inapoi");

        textTitlu.setBounds(20, 420, 120, 25);
        textDomeniu.setBounds(20, 460, 120, 25);
        textDisponibilitate.setBounds(20, 500, 120, 25);
        textEditura.setBounds(20, 540, 120, 25);
        textAutor.setBounds(20, 580, 120, 25);
        textPret.setBounds(20, 620, 120, 25);
        textLibrarie.setBounds(20,660,120,25);
        textCautareTitlu.setBounds(300, 420, 120, 25);
        textFiltrareAutor.setBounds(300, 460, 120, 25);
        textFiltrareDomeniu.setBounds(300, 540, 120, 25);
        textFiltrareEditura.setBounds(300, 500, 120, 25);
        textFiltrarePret.setBounds(600, 420, 120, 25);
        textFiltrareDisponibilitate.setBounds(600, 460, 120, 25);
        textFiltrareLibrarie.setBounds(600,500,120,25);
        textceva.setBounds(800,600,100,25);

        btnAdd.setBounds(150, 420, 130, 25);
        btnUpdate.setBounds(150, 460, 130, 25);
        btnDelete.setBounds(150, 500, 130, 25);
        btnView.setBounds(150, 540, 130, 25);
        btncautareTitlu.setBounds(450, 420, 130, 25);
        btnFiltrareDisponibilitate.setBounds(750, 460, 130, 25);
        btnFiltrarePret.setBounds(750, 420, 130, 25);
        btnFiltrareAutor.setBounds(450, 460, 130, 25);
        btnFiltrareEditura.setBounds(450, 500, 130, 25);
        btnFiltrareDomeniu.setBounds(450, 540, 130, 25);
        btnCumparare.setBounds(150, 580, 130, 25);
        btnRaport.setBounds(150, 620, 130, 25);
        btnLibrarie.setBounds(750,500,130,25);
        btnBack.setBounds(20,700,130,25);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1300, 400);



        // add JButtons to the jframe
        frame3.add(btnAdd);
        frame3.add(btnDelete);
        frame3.add(btnUpdate);
        frame3.add(btnView);
        frame3.add(btncautareTitlu);
        frame3.add(btnFiltrareAutor);
        frame3.add(btnFiltrareDisponibilitate);
        frame3.add(btnFiltrareDomeniu);
        frame3.add(btnFiltrareEditura);
        frame3.add(btnFiltrarePret);
        frame3.add(btnCumparare);
        frame3.add(btnRaport);
        frame3.add(btnLibrarie);
        frame3.add(btnBack);

        frame3.setLayout(null);

        frame3.add(pane);

        frame3.add(textTitlu);
        frame3.add(textDomeniu);
        frame3.add(textDisponibilitate);
        frame3.add(textEditura);
        frame3.add(textAutor);
        frame3.add(textPret);
        frame3.add(textLibrarie);
        frame3.add(textCautareTitlu);
        frame3.add(textFiltrareAutor);
        frame3.add(textFiltrareDomeniu);
        frame3.add(textEditura);
        frame3.add(textFiltrarePret);
        frame3.add(textFiltrareEditura);
        frame3.add(textFiltrareDisponibilitate);
        frame3.add(textFiltrareLibrarie);


        frame3.setSize(1300, 800);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

        Carte cc=new Carte();

        Subject s=new Subject(cc.getTitlu(),cc.getDisponibilitate());

            btnView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL1="SELECT * FROM Carte";
                try {
                    Statement st1=con.createStatement();
                    ResultSet rs=st1.executeQuery(SQL1);
                    ResultSetMetaData rsmd=rs.getMetaData();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    int colCount=rsmd.getColumnCount();
                    int i;
                    Object[] row=new Object[7];
                    while(rs.next()) {
                        for(i=1;i<=colCount;i++) {
                            row[i-1]=rs.getObject(i);
                           // CObserver o=new CObserver(s);
                           // c.add(rs.getObject(i));

                        }
                       // CObserver O=new CObserver(s);
                        model.addRow(row);
                    }
                }
                catch(Exception ex1)
                {
                    JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //model.setRowCount(0);
                ArrayList<Carte> c = new ArrayList<>();
                Object[] obj = new Object[7];

                String[] row = new String[7];
                int x;
                float ff;

                row[0] = textTitlu.getText();
                row[1] = textDomeniu.getText();
                row[2] = textDisponibilitate.getText();
                row[3] = textEditura.getText();
                row[4] = textAutor.getText();
                row[5] = textPret.getText();
                row[6]=textLibrarie.getText();

                x = Integer.parseInt(row[2]);
                ff = Float.parseFloat(row[5]);

                Carte cart = new Carte(row[0], row[1], x, row[3], row[4], ff,row[6]);
                PersistentaCarte pc=new PersistentaCarte();
                pc.adaugareCarte(cart);
                s.registerObserver(obs);
                observers.add(obs);
                model.addRow(row);


            }
        });

        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                int x=0;
                float ff=0;
                String[] row=new String[7];
                if (i >= 0) {

                    row[0] = textTitlu.getText();
                    row[1] = textDomeniu.getText();
                    row[2] = textDisponibilitate.getText();
                    row[3] = textEditura.getText();
                    row[4] = textAutor.getText();
                    row[5] = textPret.getText();
                    row[6]=textLibrarie.getText();

                    x = Integer.parseInt(row[2]);
                    ff = Float.parseFloat(row[5]);

                    Carte cart = new Carte(row[0], row[1], x, row[3], row[4], ff,row[6]);
                    PersistentaCarte pc=new PersistentaCarte();
                    pc.stergereCarte(cart);
                    s.removeObserver(obs,i+1);
                    observers.remove(obs);
                    // remove a row from jtable
                    model.removeRow(i);
                } else {
                    System.out.println("Delete Error");
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                textTitlu.setText(model.getValueAt(i, 0).toString());
                textDomeniu.setText(model.getValueAt(i, 1).toString());
                textDisponibilitate.setText(model.getValueAt(i, 2).toString());
                textEditura.setText(model.getValueAt(i, 3).toString());
                textAutor.setText(model.getValueAt(i, 4).toString());
                textPret.setText(model.getValueAt(i, 5).toString());
                textLibrarie.setText(model.getValueAt(i,6).toString());
                textceva.setText(model.getValueAt(i, 2).toString());
            }
        });


        btncautareTitlu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String SQL1="SELECT * FROM Carte where titlu=?";
                try {
                    String text=textCautareTitlu.getText();
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs =c.cautareTitlu(text);
                    // c.cautareTitlu(text,rs);
                    //PreparedStatement preparedStmt = con.prepareStatement(SQL1);
                    //preparedStmt.setString (1,text);
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnFiltrareAutor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL2="SELECT * FROM Carte where autor=?";
                try {
                    String text=textFiltrareAutor.getText();
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs=c.filtrareAutor(text);
                    //PreparedStatement preparedStmt = con.prepareStatement(SQL2);
                    //preparedStmt.setString (1,text);
                    //ResultSet rs;
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnFiltrareDisponibilitate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String SQL3="SELECT * FROM Carte where disponibilitate=?";
                try {
                    String text=textFiltrareDisponibilitate.getText();
                    int x=0;
                    x=Integer.parseInt(text);
                    //  PreparedStatement preparedStmt = con.prepareStatement(SQL3);
                    //preparedStmt.setInt (1,x);
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs= c.filtrareDisponibilitate(x);;
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnFiltrarePret.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //  String SQL4="SELECT * FROM Carte where pret=?";
                try {
                    String text=textFiltrarePret.getText();
                    float x=0;
                    x=Float.parseFloat(text);
                    //    PreparedStatement preparedStmt = con.prepareStatement(SQL4);
                    //
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs=c.filtrarePret(x);
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnFiltrareDomeniu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL5="SELECT * FROM Carte where domeniu=?";
                try {
                    String text=textFiltrareDomeniu.getText();
                    //PreparedStatement preparedStmt = con.prepareStatement(SQL5);
                    //preparedStmt.setString (1,text);
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs=c.filtrareDomeniu(text);
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnFiltrareEditura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String SQL6="SELECT * FROM Carte where editura=?";
                try {
                    String text=textFiltrareEditura.getText();
                    // PreparedStatement preparedStmt = con.prepareStatement(SQL6);
                    //preparedStmt.setString (1,text);
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs=c.filtrareEditura(text);
                    // rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        int[] vec=new int[10];
        for(int j=0;j<vec.length;j++)
            vec[j]=0;


        btnCumparare.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                int x = 0;
                int y = 0;
                float ff = 0;
                String ceva1;
                String[] row = new String[7];
                if (i >= 0) {

                    row[0] = textTitlu.getText();
                    row[1] = textDomeniu.getText();
                    row[2] = textDisponibilitate.getText();
                    row[3] = textEditura.getText();
                    row[4] = textAutor.getText();
                    row[5] = textPret.getText();
                    row[6] = textLibrarie.getText();
                    ceva1 = textceva.getText();

                    x = Integer.parseInt(row[2]);
                    ff = Float.parseFloat(row[5]);
                    y = Integer.parseInt(ceva1);

                    Carte cart = new Carte(row[0], row[1], x, row[3], row[4], ff, row[6]);
                    if (x >= 0) {
                        PersistentaCarte pc = new PersistentaCarte();
                        pc.cumparareCarte(cart);

                        ArrayList<Carte> carti = new ArrayList<Carte>();
                        PersistentaCarte c1 = new PersistentaCarte();
                        c1.adaugareArray(carti);
                        for (Carte ci : carti)
                            if (Arrays.asList(carti).contains(cart)) ;
                        {
                            if(vec[i]==0) {

                                CObserver o1 = new CObserver(s);
                                o1.update(y - cart.getDisponibilitate());
                            }
                            else
                                System.out.println("disponibilitate noua:"+(y-cart.getDisponibilitate()));
                            vec[i]=1;
                        }
                    } else
                        System.out.println("Delete Error");

                    // remove a row from jtable
                } else {
                    System.out.println("Delete Error");
                }
                String SQL1 = "SELECT * FROM Carte";
                try {
                    Statement st1 = con.createStatement();
                    ResultSet rs = st1.executeQuery(SQL1);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    int colCount = rsmd.getColumnCount();
                    int j;
                    Object[] row1 = new Object[8];
                    while (rs.next()) {
                        for (j = 1; j <= colCount; j++) {
                            row1[j - 1] = rs.getObject(j);
                            // CObserver o=new CObserver(s);
                            // c.add(rs.getObject(i));

                        }
                        model.addRow(row1);
                    }
                } catch (Exception ex1) {
                    JOptionPane.showMessageDialog(null, "Eroare de vizualizare");
                }
            }


        });

        btnLibrarie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String SQL10="SELECT * FROM Carte where librarie=?";
                try {
                    String text=textFiltrareLibrarie.getText();
                    // PreparedStatement preparedStmt = con.prepareStatement(SQL10);
                    //  preparedStmt.setString (1,text);
                    PersistentaCarte c=new PersistentaCarte();
                    ResultSet rs=c.filtrareLibrarie(text);
                    //rs=preparedStmt.executeQuery();
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int column=rsmd.getColumnCount();
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        Object[] row=new Object[7];
                        for(int i=1;i<=column;i++) {
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

        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                int x = 0;
                float ff = 0;
                String[] row = new String[7];
                if (i >= 0) {

                    row[0] = textTitlu.getText();
                    row[1] = textDomeniu.getText();
                    row[2] = textDisponibilitate.getText();
                    row[3] = textEditura.getText();
                    row[4] = textAutor.getText();
                    row[5] = textPret.getText();
                    row[6] = textLibrarie.getText();

                    x = Integer.parseInt(row[2]);
                    ff = Float.parseFloat(row[5]);

                    Carte cart = new Carte(row[0], row[1], x, row[3], row[4], ff, row[6]);
                    PersistentaCarte pc = new PersistentaCarte();
                    pc.updateCarte(cart);


                }
            }
        });

        btnRaport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ArrayList<Carte> carti=new ArrayList<Carte>();
                PersistentaCarte c1=new PersistentaCarte();
                c1.adaugareArray(carti);
                for(Carte c2:carti)
                    System.out.println(c2);
                RaportJSON json=new RaportJSON();
                json.scrie(carti);
                RaportXML xml=new RaportXML();
                xml.scrie(carti);
                RaportCSV csv=new RaportCSV();
                csv.scrie(carti);

            }
        });

        btnBack.addActionListener(new ActionListener() {

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
                        String s1=p.getProperty("btnAdaugare");
                        String s2=p.getProperty("btnStergere");
                        String s3=p.getProperty("btnActualizare");
                        String s4=p.getProperty("btnVizualizare");
                        String s5=p.getProperty("btnInapoi");
                        String s6=p.getProperty("btnCumparare");
                        String s7=p.getProperty("btnRaport");
                        String s8=p.getProperty("btnCautareTitlu");
                        String s9=p.getProperty("btnFiltrareAutor");
                        String s10=p.getProperty("btnFiltrareEditura");
                        String s11=p.getProperty("btnFiltrareDomeniu");
                        String s12=p.getProperty("btnFiltrareDisponibilitate");
                        String s13=p.getProperty("btnFiltrarePret");
                        String s14=p.getProperty("btnFiltrareLibrarie");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                        btnCumparare.setText(s6);
                        btnRaport.setText(s7);
                        btncautareTitlu.setText(s8);
                        btnFiltrareAutor.setText(s9);
                        btnFiltrareEditura.setText(s10);
                        btnFiltrareDomeniu.setText(s11);
                        btnFiltrareDisponibilitate.setText(s12);
                        btnFiltrarePret.setText(s13);
                        btnLibrarie.setText(s14);
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
                        String s1=p.getProperty("btnAdaugare");
                        String s2=p.getProperty("btnStergere");
                        String s3=p.getProperty("btnActualizare");
                        String s4=p.getProperty("btnVizualizare");
                        String s5=p.getProperty("btnInapoi");
                        String s6=p.getProperty("btnCumparare");
                        String s7=p.getProperty("btnRaport");
                        String s8=p.getProperty("btnCautareTtilu");
                        String s9=p.getProperty("btnFiltrareAutor");
                        String s10=p.getProperty("btnFiltrareEditura");
                        String s11=p.getProperty("btnFiltrareDomeniu");
                        String s12=p.getProperty("btnFiltrareDisponibilitate");
                        String s13=p.getProperty("btnFiltrarePret");
                        String s14=p.getProperty("btnFiltrareLibrarie");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                        btnCumparare.setText(s6);
                        btnRaport.setText(s7);
                        btncautareTitlu.setText(s8);
                        btnFiltrareAutor.setText(s9);
                        btnFiltrareEditura.setText(s10);
                        btnFiltrareDomeniu.setText(s11);
                        btnFiltrareDisponibilitate.setText(s12);
                        btnFiltrarePret.setText(s13);
                        btnLibrarie.setText(s14);

                        //DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(columns1);

                        table.setModel(model);

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
                        String s1=p.getProperty("btnAdaugare");
                        String s2=p.getProperty("btnStergere");
                        String s3=p.getProperty("btnActualizare");
                        String s4=p.getProperty("btnVizualizare");
                        String s5=p.getProperty("btnInapoi");
                        String s6=p.getProperty("btnCumparare");
                        String s7=p.getProperty("btnRaport");
                        String s8=p.getProperty("btnCautareTtilu");
                        String s9=p.getProperty("btnFiltrareAutor");
                        String s10=p.getProperty("btnFiltrareEditura");
                        String s11=p.getProperty("btnFiltrareDomeniu");
                        String s12=p.getProperty("btnFiltrareDisponibilitate");
                        String s13=p.getProperty("btnFiltrarePret");
                        String s14=p.getProperty("btnFiltrareLibrarie");




                        btnAdd.setText(s1);
                        btnDelete.setText(s2);
                        btnUpdate.setText(s3);
                        btnView.setText(s4);
                        btnBack.setText(s5);
                        btnCumparare.setText(s6);
                        btnRaport.setText(s7);
                        btncautareTitlu.setText(s8);
                        btnFiltrareAutor.setText(s9);
                        btnFiltrareEditura.setText(s10);
                        btnFiltrareDomeniu.setText(s11);
                        btnFiltrareDisponibilitate.setText(s12);
                        btnFiltrarePret.setText(s13);
                        btnLibrarie.setText(s14);

                       // DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(columns2);

                        table.setModel(model);
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

