package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long r;
    JTextField nameTextFild,fathernameTextFild,
            emailTextFild,addressTextFild,cityTextFild,
            stateTextFild, zipTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton  married,single,other, male,female,other1;

    JLabel formno,personaldetails,name, fname , dob,gender,email,relationship,address,city,state,pin;

    SignupOne(){
        setTitle("SIGN UP FORM");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        Random ran= new Random();
//////////////        int r=ran.nextInt(1000,9999);
         r=Math.abs((ran.nextLong() % 9000L)+1000L);

         formno=new JLabel("APPLICATION FORM NO :"+ r);
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

         personaldetails=new JLabel("Page 1 : Personal Details");
        personaldetails.setFont(new Font("Railway",Font.BOLD,22));
        personaldetails.setBounds(260,80,400,30);
        add(personaldetails);

        name = new JLabel("Name :");
        name.setFont(new Font("Railway",Font.BOLD,12));
        name.setBounds(100,140,100,30);
        add(name);

         nameTextFild =new JTextField();
        nameTextFild.setFont(new Font("Railway",Font.BOLD,14));
        nameTextFild.setBounds(250,140,300,30);
        add(nameTextFild);

         fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Railway",Font.BOLD,12));
        fname.setBounds(100,180,100,30);
        add(fname);

         fathernameTextFild =new JTextField();
        fathernameTextFild.setFont(new Font("Railway",Font.BOLD,14));
        fathernameTextFild.setBounds(250,180,300,30);
        add(fathernameTextFild);


         dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Railway",Font.BOLD,12));
        dob.setBounds(100,220,300,30);
        add(dob);

       dateChooser=new JDateChooser();
        dateChooser.setBounds(250,220,300,30);
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setBackground(Color.WHITE);
        add(dateChooser);


         gender = new JLabel("Gender :");
        gender.setFont(new Font("Railway",Font.BOLD,12));
        gender.setBounds(100,260,100,30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);male.setBounds(250,260,80,30);
        add(male);
        ButtonGroup  gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

         other= new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(450,260,80,30);
        add(other);
        gendergroup.add(other);


        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(350,260,80,30);
        add(female);
        gendergroup.add(female);


       email= new JLabel("Email Address :");
        email.setFont(new Font("Railway",Font.BOLD,12));
        email.setBounds(100,300,100,30);
        add(email);

       emailTextFild =new JTextField();
        emailTextFild.setFont(new Font("Railway",Font.BOLD,14));
        emailTextFild.setBounds(250,300,300,30);
        add(emailTextFild);


         relationship = new JLabel("Marital Status :");
        relationship.setFont(new Font("Railway",Font.BOLD,12));
        relationship.setBounds(100,340,100,30);
        add(relationship);

        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(250,340,80,30);
        add(married);
        gendergroup.add(married);


        single = new JRadioButton("Single");
        single.setBackground(Color.WHITE);
        single.setBounds(350,340,80,30);
        add(single);
        gendergroup.add(single);

       other1= new JRadioButton("Other");
        other1.setBackground(Color.WHITE);
        other1.setBounds(450,340,80,30);
        add(other1);
        gendergroup.add(other1);

        ButtonGroup  gendergroup1=new ButtonGroup();
        gendergroup1.add(married);
        gendergroup1.add(single);
        gendergroup1.add(other1);

        address = new JLabel("Address :");
        address.setFont(new Font("Railway",Font.BOLD,12));
        address.setBounds(100,380,100,30);
        add(address);
        addressTextFild =new JTextField();
        addressTextFild.setFont(new Font("Railway",Font.BOLD,14));
        addressTextFild.setBounds(250,380,300,30);
        add(addressTextFild);

         city = new JLabel("City :");
        city.setFont(new Font("Railway",Font.BOLD,12));
        city.setBounds(100,420,100,30);
        add(city);

        cityTextFild =new JTextField();
        cityTextFild.setFont(new Font("Railway",Font.BOLD,14));
        cityTextFild.setBounds(250,420,300,30);
        add(cityTextFild);

        state = new JLabel("State :");
        state.setFont(new Font("Railway",Font.BOLD,12));
        state.setBounds(100,460,100,30);
        add(state);

        stateTextFild =new JTextField();
        stateTextFild.setFont(new Font("Railway",Font.BOLD,14));
        stateTextFild.setBounds(250,460,300,30);
        add(stateTextFild);

        pin = new JLabel("Pin Code :");
       pin.setFont(new Font("Railway",Font.BOLD,12));
        pin.setBounds(100,500,100,30);
        add(pin);

         zipTextField =new JTextField();
        zipTextField.setFont(new Font("Railway",Font.BOLD,12));
        zipTextField.setBounds(250,500,300,30);
        add(zipTextField);


        next=new JButton("NEXT--->>");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        setFont(new Font("Railway",Font.BOLD,40));
        next.setBounds(250,550,300,30);
        next.addActionListener(this);
        add(next);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
       String formno=""+r;
       String name=nameTextFild.getText();
       String fname=fathernameTextFild.getText();
       String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
       String gender = null;
       if(male.isSelected()){
         gender="Male";
       }
       else if(female.isSelected()){
           gender="Female";
       }
       else if(other.isSelected()){
           gender="Other";
       }
       String email=emailTextFild.getText();
       String marital_status=null;
        if(married.isSelected()){
            marital_status="Married";
        }
        else if(single.isSelected()){
            marital_status="Single";
        }
        else if(other.isSelected()){
            marital_status="Other";
        }
        String address=addressTextFild.getText();
        String city=cityTextFild.getText();
        String state=stateTextFild.getText();
        String pin=zipTextField.getText();

        try{
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name is required");

            }
            else {
                conn c=new conn();
                String query= "insert into signUp values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+ marital_status +"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
//
////        try{
//////            if(fnema.equals("")){
//////                JOptionPane.showMessageDialog(null,"Father's Name is required");
//////            }
//////
//////        }catch (Exception e){
//////            System.out.println(e);
//////        }
//////        try{
//////            if(dob.equals("")){
//////                JOptionPane.showMessageDialog(null,"Date of Birth is required");
//////            }
//////
//////        }catch (Exception e){
//////            System.out.println(e);
//////        }
//////        try{
//////            if(gender.equals("")){
//////                JOptionPane.showMessageDialog(null,"Gender is required");
//////            }
//////
//////        }catch (Exception e){
//////            System.out.println(e);
//////        }
//////        try{
//////            if(email.equals("")){
//////                JOptionPane.showMessageDialog(null,"Email Address is required");
//////            }
//////
//////        }catch (Exception e){
//////            System.out.println(e);
//////        }
//////        try{
//////            if(address.equals("")){
//////                JOptionPane.showMessageDialog(null,"Address is required");
//////            }
//////
//////        }catch (Exception e){
//////            System.out.println(e);
//////        }
////
////
    }
    public static void main(String[] args) {
        new SignupOne();
}
}
