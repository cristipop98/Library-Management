package view;

import controller.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Properties;

public class FirstPage extends JFrame {

    public JFrame firstPage;
    private JFrame frame1;
    private JFrame frame2;
    private JPanel log;
    private JTextField textField;
    private JTextField textField_1;
    private JButton BtnEmployee;
    private JButton BtnAdministrator;
    private JLabel label1;
    private String eng="english";
    private String ro="romana";
    private String de="deutsch";
    private String language;





    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FirstPage window = new FirstPage();
                    window.firstPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Client client = new Client("127.0.0.1", 5000);
    }
    public FirstPage(){
        initialize();
        //loadLanguages(de);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void initialize()
    {
        firstPage = new JFrame();
        firstPage.setBounds(100, 100, 450, 300);
        firstPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstPage.getContentPane().setLayout(null);
        firstPage.setTitle("Librarie");
        frame1=new JFrame();
        frame1.setBounds(100,100,450,300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setLayout(null);
        frame2=new JFrame();
        frame2.setBounds(100,100,450,300);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setLayout(null);

        BtnEmployee=new JButton("Autentificare ca si angajat");
        BtnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAngajat LoginPage1=new LoginAngajat();
                LoginPage1.setVisible(true);

            }
        });
        BtnEmployee.setBounds(12,159,184,56);
        firstPage.getContentPane().add(BtnEmployee);

        BtnAdministrator = new JButton("Autentificare ca si administrator");
        BtnAdministrator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Login LoginPage=new Login();
                LoginPage.setVisible(true);
                firstPage.setVisible(false);



            }
        });
        BtnAdministrator.setBounds(236, 159, 184, 56);
        firstPage.getContentPane().add(BtnAdministrator);

        label1 = new JLabel("Librarie");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(132, 61, 146, 56);
        firstPage.getContentPane().add(label1);



        JComboBox combo=new JComboBox();

        combo.addItem("romana");
        combo.addItem("english");
        combo.addItem("deutsch");

        combo.setBounds(300,20,100,25);
        firstPage.add(combo);

        JButton btnCombo=new JButton("Ok");
        btnCombo.setBounds(300,50,100,25);
        firstPage.add(btnCombo);

        btnCombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (combo.getSelectedIndex() == 0)
                {
                    setRomana(language);
                    try {
                        Properties p = new Properties();
                        p.load(FirstPage.class.getResourceAsStream(language + ".properties"));
                        String s1=p.getProperty("btnLogareAngajat");
                        String s2=p.getProperty("btnLoginAdmin");
                        String s3=p.getProperty("label");
                        String s4=p.getProperty("firstPage");




                        BtnEmployee.setText(s1);
                        BtnAdministrator.setText(s2);
                        label1.setText(s3);
                        firstPage.setTitle(s4);
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
                        String s1=p.getProperty("btnLogareAngajat");
                        String s2=p.getProperty("btnLoginAdmin");
                        String s3=p.getProperty("label");
                        String s4=p.getProperty("firstPage");




                        BtnEmployee.setText(s1);
                        BtnAdministrator.setText(s2);
                        label1.setText(s3);
                        firstPage.setTitle(s4);
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
                        String s1=p.getProperty("btnLogareAngajat");
                        String s2=p.getProperty("btnLoginAdmin");
                        String s3=p.getProperty("label");
                        String s4=p.getProperty("firstPage");


                        BtnEmployee.setText(s1);
                        BtnAdministrator.setText(s2);
                        label1.setText(s3);
                        firstPage.setTitle(s4);
                    }
                    catch(Exception ee)
                    {
                        //  JOptionPane.showMessageDialog(this, e.getMessage());
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
