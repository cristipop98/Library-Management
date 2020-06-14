package view;

import server.Admin;
import server.Angajat;
import server.PersistentaAdmin;
import server.PersistentaAngajat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

public class Login extends JFrame {
    private JPanel log;
    private JTextField textField;
    private JPasswordField textField_1;
    private JPanel firstPage;
    private String language;
    private JLabel label1;
    private JLabel email;
    private JLabel pass;
    private JButton logIn;

    public Login() {

        MeniuAdmin ad=new MeniuAdmin();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        log = new JPanel();
        log.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(log);
        log.setLayout(null);

        label1 = new JLabel("Administrator");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(132, 41, 146, 56);
        log.add(label1);

        email = new JLabel("Utilizator:");
        email.setFont(new Font("Tahoma", Font.BOLD, 17));
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setBounds(25, 89, 91, 33);
        log.add(email);

        pass = new JLabel("Parola:");
        pass.setFont(new Font("Tahoma", Font.BOLD, 17));
        pass.setHorizontalAlignment(SwingConstants.CENTER);
        pass.setBounds(25, 135, 91, 33);
        log.add(pass);

        textField = new JTextField();
        textField.setBounds(141, 96, 176, 22);
        log.add(textField);
        textField.setColumns(10);

        textField_1 = new JPasswordField();
        textField_1.setBounds(141, 142, 176, 22);
        log.add(textField_1);
        textField_1.setColumns(10);

        JComboBox combo=new JComboBox();

        combo.addItem("romana");
        combo.addItem("english");
        combo.addItem("deutsch");

        combo.setBounds(300,20,100,25);
        log.add(combo);


        logIn = new JButton("Autentificare");
        ArrayList<Admin> admini=new ArrayList<Admin>();
        PersistentaAdmin a=new PersistentaAdmin();
        a.adaugareArray(admini);
        for(Admin i:admini)
            System.out.println(i);
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String pas = textField_1.getText();
                // System.out.println(aa.getUser());
                //System.out.println(aa.getParola());
                //  if(username.equals(aa.getUser()) && pas.equals(aa.getParola())){
                for(Admin i:admini)
                if (username.equals(i.getUser()) && pas.equals(i.getParola())) {
                    if(combo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Conectare reusita");
                    }
                    else if(combo.getSelectedIndex() == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Succesful connection");
                    }
                    else if(combo.getSelectedIndex() == 2)
                    {
                        JOptionPane.showMessageDialog(null, "\n" +"erfolgreiche Verbindung");
                    }
                    ad.initializare();
                    ad.setVisible(true);
                    setVisible(false);

                } else {
                    if(combo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Utilizator/Parola gresita");
                    }
                    else if(combo.getSelectedIndex() == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Wrong username/passowrd");
                    }
                    else if(combo.getSelectedIndex() == 2)
                    {
                        JOptionPane.showMessageDialog(null, "Benutzer/Kennwort falsch");
                    }
                }

            }
        });
        logIn.setBounds(75, 202, 97, 25);
        log.add(logIn);

        JButton Cancel1 = new JButton("Cancel");
        Cancel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                firstPage.setVisible(true);
            }
        });
        Cancel1.setBounds(263, 202, 97, 25);
        log.add(Cancel1);


        JButton btnCombo=new JButton("Ok");
        btnCombo.setBounds(300,50,100,25);
        log.add(btnCombo);

        btnCombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (combo.getSelectedIndex() == 0)
                {
                    setRomana(language);
                    try {
                        Properties p = new Properties();
                        p.load(FirstPage.class.getResourceAsStream(language + ".properties"));
                        String s1=p.getProperty("labelEmailAdmin");
                        String s2=p.getProperty("labelPassAdmin");
                        String s3=p.getProperty("btnLogin");
                        String s4=p.getProperty("labelAdmin");




                        email.setText(s1);
                        pass.setText(s2);
                        logIn.setText(s3);
                        label1.setText(s4);
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
                        String s1=p.getProperty("labelEmailAdmin");
                        String s2=p.getProperty("labelPassAdmin");
                        String s3=p.getProperty("btnLogin");
                        String s4=p.getProperty("labelAdmin");




                        email.setText(s1);
                        pass.setText(s2);
                        logIn.setText(s3);
                        label1.setText(s4);
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
                        String s1=p.getProperty("labelEmailAdmin");
                        String s2=p.getProperty("labelPassAdmin");
                        String s3=p.getProperty("btnLogin");
                        String s4=p.getProperty("labelAdmin");




                        email.setText(s1);
                        pass.setText(s2);
                        logIn.setText(s3);
                        label1.setText(s4);
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
