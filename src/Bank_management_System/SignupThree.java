package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JLabel l1,type ,cardNum,pin,cardshow,pinshow,service;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancle;
    String formno;

    SignupThree(String formno){
        l1=new JLabel("Page 3 : Account Details ");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(250,40,400,30);
        add(l1);
       type=new JLabel("Account Type : ");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        type.setBackground(Color.WHITE);
        add(type);

        ButtonGroup bt= new ButtonGroup();
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBounds(100,180,150,30);
        add(r1);
        bt.add(r1);

        r2=new JRadioButton("Fixed Deposit Accoumt");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBounds(300,180,200,30);
        add(r2);
        bt.add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBounds(100,220,200,30);
        add(r3);
        bt.add(r3);


        r4=new JRadioButton("Recurring Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBounds(300,220,200,30);
        add(r4);
        bt.add(r4);


        cardNum=new JLabel("Card Number :"+"    XXXX-XXXX-XXXX-9135  ");
        cardNum.setFont(new Font("Railway",Font.BOLD,22));
        cardNum.setBounds(100,260,500,30);
        add(cardNum);
        cardshow=new JLabel("Your 16 digit ATM NO :  ");
        cardshow.setFont(new Font("Railway",Font.BOLD,15));
        cardshow.setBounds(100,300,300,20);
        add(cardshow);


        pin =new JLabel("Security Num :  "+"   XXXX");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,340,500,30);
        add(pin);
        pinshow=new JLabel("Your 12 digit ATM NO :  ");
        pinshow.setFont(new Font("Railway",Font.BOLD,15));
        pinshow.setBounds(100,380,300,20);
        add(pinshow);;

        service =new JLabel("SERVICE REQUIRED");
        service.setFont(new Font("Railway",Font.BOLD,18));
        service.setBounds(100,420,500,30);
        add(service);
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,460,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(300,460,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,500,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS Alert");
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(300,500,200,30);
        add(c4);

        c5=new JCheckBox("Cheque BOOK");
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,540,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(300,540,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declares that the above entered details are correct");
        c7.setFont(new Font("Railway",Font.BOLD,14));
        c7.setBounds(100,600,550,30);
        add(c7);

     submit=new JButton("Submit");
     submit.setFont(new Font("Railway",Font.BOLD,16));
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.setBounds(200,650,100,30);
     submit.addActionListener(this);
     add(submit);
     cancle=new JButton("Cancle");
     cancle.setFont(new Font("Railway",Font.BOLD,16));
     cancle.setBackground(Color.BLACK);
     cancle.setForeground(Color.WHITE);
     cancle.setBounds(350,650,100,30);
     cancle.addActionListener(this);
     add(cancle);



        setSize(850,820);
        setLayout(null);
        setLocation(350,20);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==submit){
      String accountType=null;
      if(r1.isSelected()){
       accountType=" Saving Account";
      } else if (r2.isSelected()) {
       accountType=" Fixed Deposit Accoumt";
      }
      else if (r3.isSelected()) {
     accountType=" Current Account";
      }
      else if (r4.isSelected()) {
       accountType=" Recurring Account";
      }
      Random re=new Random();
      String cardNumber=""+re.nextLong(8757883500000000l,9999999999999999l);

      String pinNumber=""+re.nextInt(1000,9999);

      String facility="";
      if (c1.isSelected()){
       facility=facility+" ATM Card";
      }
      else if (c2.isSelected()){
       facility=facility+" Internet Banking";
      }

      else if (c3.isSelected()){
       facility=facility+" Mobile Banking";
      }

     else if (c4.isSelected()){
       facility=facility+" Email & SMS Alert";
      }

     else if (c5.isSelected()){
       facility=facility+ " Cheque BOOK";
      }

     else if (c6.isSelected()){
       facility=facility+" E-Statement";
      }


      try{
      if(accountType.isEmpty()){
       JOptionPane.showMessageDialog(null,"Account type is required");
      } else {
       conn Conn=new conn();

       String query1="insert into signupThree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
       Conn.s.executeUpdate(query1);
       String query2="insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
       Conn.s.executeUpdate(query2);

       setVisible(false);

       JOptionPane.showMessageDialog(null,"Card no ; "+cardNumber+"\nPin no :"+pinNumber);

      }
      setVisible(false);
      new Deposit(pinNumber).setVisible(true);
      }
      catch (Exception e){
      System.out.println(e);
     }


     } else if (ae.getSource()==cancle) {

      setVisible(false);
      new Login().setVisible(true);
     }
}
 
    public static void main(String[] args) {
        new SignupThree("");
    }
}