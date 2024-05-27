package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JLabel text;
    JTextField amount;
    JButton deposit,back;
    String pinNumber;

    Deposit(String pinNumber){
        this.pinNumber=pinNumber;
//        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Bank_management_System/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        setBounds(0,0,900,900);
       add(image);

       text =new JLabel("ENTER THE AMOUNT");
       text.setForeground(Color.WHITE);
       text.setBackground(Color.BLACK);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(170,380,400,20);
       image.add(text);


        amount =new JTextField();
        amount.setForeground(Color.WHITE);
        amount.setBackground(Color.BLACK);
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(170,420,200,25);
        image.add(amount);

        deposit = new JButton("ENTER");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(170,485,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String money=amount.getText();
            Date date =new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null,"Enter an amount to deposit");
            }
            else {
                try {
                conn conn=new conn();
                String query="insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+money+"')";

                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+money+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
       new Deposit("");
    }
}
