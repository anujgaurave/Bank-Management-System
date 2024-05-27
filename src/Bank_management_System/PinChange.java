package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JLabel text ,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Bank_management_System/icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text =new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,30);
        image.add(text);


        pintext =new JLabel("Enter new PIN");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(160,320,180,20);
        image.add(pintext);

        pin =new JPasswordField();
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("Railway",Font.BOLD,25));
        pin.setBounds(320,320,180,25);
        image.add(pin);

        repintext =new JLabel("Re-enter PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(160,380,180,20);
        image.add(repintext);

        repin =new JPasswordField();
        repin.setForeground(Color.BLACK);
        repin.setFont(new Font("Railway",Font.BOLD,25));
        repin.setBounds(320,380,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(358,455,150,27);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(160,455,150,27);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"PIN DOES NOT MATCH");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter pin");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter pin");
                return;
            }
            conn conn=new conn();

            String query1="update bank set pin='"+npin+"' where pin ='"+pinNumber+"'";
            String query2="update login set PinNumber='"+npin+"' where PinNumber ='"+pinNumber+"'";
            String query3="update signupThree set pinNumber ='"+npin+"' where pinNumber ='"+pinNumber+"'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"PIN changed Successfully");
            setVisible(false);
            new Transactions(npin).setVisible(true);
        }

        catch (Exception e){
            System.out.println(e);
        }
    }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
