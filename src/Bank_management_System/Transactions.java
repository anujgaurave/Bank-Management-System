package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrowl,fastcash,ministatement,pinchange,balanceenquery,exit;
   String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Bank_management_System/icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Please select your option");
        text.setBounds(235,300,700,35);
        text.setFont(new Font("Railway",Font.BOLD,15));
        text.setForeground(Color.RED);
        image.add(text);


        deposit= new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setForeground(Color.white);
        deposit.setBackground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrowl= new JButton("Cash Withdrowl");
        withdrowl.setBounds(360,415,150,30);
        withdrowl.setForeground(Color.white);
        withdrowl.setBackground(Color.RED);
        withdrowl.addActionListener(this);
        image.add(withdrowl);


        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setForeground(Color.white);
        fastcash.setBackground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);


        ministatement= new JButton("Mini Statement");
        ministatement.setBounds(360,450,150,30);
        ministatement.setForeground(Color.white);
        ministatement.setBackground(Color.BLACK);
        ministatement.addActionListener(this);
        image.add(ministatement);


        pinchange= new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setForeground(Color.white);
        pinchange.setBackground(Color.BLACK);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquery= new JButton("Balance Enquery");
        balanceenquery.setBounds(360,485,150,30);
        balanceenquery.setForeground(Color.white);
        balanceenquery.setBackground(Color.BLACK);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);

        exit= new JButton("EXIT");
        exit.setBounds(260,520,150,30);
        exit.setForeground(Color.white);
        exit.setBackground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);


//        JLabel text -new JLabel("Pleac")
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==withdrowl) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource()==balanceenquery) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
