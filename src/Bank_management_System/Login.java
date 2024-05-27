package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,signUP;
    JTextField cardTextFild;
    JPasswordField pinTextFild;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Bank_management_System/icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel Cardno = new JLabel("Card no : ");
        Cardno.setFont(new Font("Railway",Font.BOLD, 28));
        Cardno.setBounds(120,150,150,40);
        add( Cardno);

        cardTextFild = new JTextField();
        cardTextFild.setBounds(300 ,155,250,30);
        cardTextFild.setFont(new Font("Atial",Font.BOLD,15));
        add(cardTextFild);

        JLabel Pin=new JLabel("PIN :");
        Pin.setFont(new Font("Railway",Font.BOLD,28));
        Pin.setBounds(120,200,400,40);
        add(Pin);
        pinTextFild= new JPasswordField();
        pinTextFild.setBounds(300 ,205,250,30);
        pinTextFild.setFont(new Font("Atial",Font.BOLD,15));
        add(pinTextFild);


        login = new JButton("SIGN IN");
        login.setBounds(300,250,100,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450,250,100,30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);


        signUP = new JButton("SIGN UP");
        signUP.setBounds(300,300,250,30);
        signUP.setForeground(Color.WHITE);
        signUP.setBackground(Color.BLACK);
        signUP.addActionListener(this);
        add(signUP);



        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==signUP) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(a.getSource()==login){
            conn Conn =new conn();
            String cardNumber =cardTextFild.getText();
            String pinNumber =pinTextFild.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber ='"+pinNumber+"'";
            try{
                ResultSet rs =Conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Card number or pin");
                }
            }catch (Exception e){
                System.out.println();
            }

        }
        else if (a.getSource()==clear){
            pinTextFild.setText("");
            cardTextFild.setText("");
        }
    }
    public static void main(String[] args) {
        new Login();
}
}