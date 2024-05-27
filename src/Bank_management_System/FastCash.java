package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrowl,fastcash,ministatement,pinchange,balanceenquery,back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Bank_management_System/icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Select withdrawl amount");
        text.setBounds(235,300,700,35);
        text.setFont(new Font("Railway",Font.BOLD,15));
        text.setForeground(Color.RED);
        image.add(text);


        deposit= new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.setForeground(Color.white);
        deposit.setBackground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrowl= new JButton("Rs 500");
        withdrowl.setBounds(360,415,150,30);
        withdrowl.setForeground(Color.white);
        withdrowl.setBackground(Color.black);
        withdrowl.addActionListener(this);
        image.add(withdrowl);


        fastcash= new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.setForeground(Color.white);
        fastcash.setBackground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);


        ministatement= new JButton("Rs 2000");
        ministatement.setBounds(360,450,150,30);
        ministatement.setForeground(Color.white);
        ministatement.setBackground(Color.BLACK);
        ministatement.addActionListener(this);
        image.add(ministatement);


        pinchange= new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.setForeground(Color.white);
        pinchange.setBackground(Color.BLACK);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquery= new JButton("Rs 10000");
        balanceenquery.setBounds(360,485,150,30);
        balanceenquery.setForeground(Color.white);
        balanceenquery.setBackground(Color.BLACK);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);

        back= new JButton("Back");
        back.setBounds(260,520,150,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);


//        JLabel text -new JLabel("Pleac")
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
        } else {
            String amount =((JButton)ae.getSource()).getText().substring(3);
            conn c=new conn();

        try{
            ResultSet rs=c.s.executeQuery("Select * from bank where pin ='"+pinNumber+"'");
            int balance=0;
            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource()!=back && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }
            Date date=new Date();
            String query ="insert into bank values('"+pinNumber+"','"+date+"','withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
