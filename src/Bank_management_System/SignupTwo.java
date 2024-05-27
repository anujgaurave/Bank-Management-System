package Bank_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField adharTextFild,
           panNoTextFild;
    JButton next;
    JRadioButton  no, yes;
    JComboBox religionCombo,catogoryCombo,incomeCombo,qualificationCombo,ocupationCombo;

    JLabel additionalDetails, religion, income , qualification,adhar,panNo,seniorCitizen,existingAccount,ocupation,catogory;

    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);


        additionalDetails=new JLabel("Page 2 : Additional Details of ");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(260,80,400,30);
        add(additionalDetails);

        religion = new JLabel("Religion :");
        religion.setFont(new Font("Railway",Font.BOLD,12));
        religion.setBounds(100,140,100,30);

        add( religion);

        String religionopt[] ={"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHER"};
        religionCombo =new JComboBox(religionopt);
        religionCombo.setFont(new Font("Railway",Font.BOLD,14));
        religionCombo.setBounds(250,140,300,30);
        religionCombo.setBackground(Color.WHITE);
        religionCombo.setForeground(Color.BLACK);
        add( religionCombo);

       catogory = new JLabel("Catogory :");
        catogory.setFont(new Font("Railway",Font.BOLD,12));
        catogory.setBounds(100,180,100,30);
        add(catogory);

         String catogoryopt[]={"GENERAL","OBC","SC","ST"};
        catogoryCombo = new JComboBox(catogoryopt);
        catogoryCombo.setFont(new Font("Railway",Font.BOLD,13));
        catogoryCombo.setBounds(250,180,300,30);
        catogoryCombo.setBackground(Color.WHITE);
        catogoryCombo.setForeground(Color.BLACK);
        add(catogoryCombo);


        income = new JLabel("Income :");
        income.setFont(new Font("Railway",Font.BOLD,12));
        income.setBounds(100,220,100,30);
        add(income);

        String incomeOpt[]= {"null","0-100000","100000-500000","500000-1000000","1000000-above"};
        incomeCombo =new JComboBox(incomeOpt);
        incomeCombo.setFont(new Font("Railway",Font.BOLD,14));
        incomeCombo.setBounds(250,220,300,30);
        incomeCombo.setForeground(Color.BLACK);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);


        qualification = new JLabel("Qualification :");
        qualification.setFont(new Font("Railway",Font.BOLD,12));
        qualification.setBounds(100,260,300,30);
        add(qualification);

        String qualificationOpt[]={"Non-Graduate","Graduate","Post-Graduate","Doctorte","Other"};
        qualificationCombo=new JComboBox(qualificationOpt);
        qualificationCombo.setBounds(250,260,300,30);
        qualificationCombo.setForeground(Color.BLACK);
        qualificationCombo.setBackground(Color.WHITE);
        add(qualificationCombo);


        ocupation = new JLabel("Occupation :");
        ocupation.setFont(new Font("Railway",Font.BOLD,12));
        ocupation.setBounds(100,300,100,30);
        add(ocupation);


        String ocupationOpt[]={"Unemployed","self-employed","Businessman","Govt-employee","Private-employee","Other"};
        ocupationCombo =new JComboBox(ocupationOpt);
        ocupationCombo.setFont(new Font("Railway",Font.BOLD,12));
        ocupationCombo.setBounds(250,300,300,30);
        ocupationCombo.setBackground(Color.WHITE);
        ocupationCombo.setForeground(Color.BLACK);
        add(ocupationCombo);


        panNo= new JLabel("PAN Number :");
        panNo.setFont(new Font("Railway",Font.BOLD,12));
        panNo.setBounds(100,340,100,30);
        add(panNo);

        panNoTextFild =new JTextField();
        panNoTextFild.setFont(new Font("Railway",Font.BOLD,14));
        panNoTextFild.setBounds(250,340,300,30);
        add(panNoTextFild);


        adhar = new JLabel("Adhar Number  :");
        adhar.setFont(new Font("Railway",Font.BOLD,12));
        adhar.setBounds(100,380,100,30);
        add(adhar);

        adharTextFild =new JTextField();
        adharTextFild.setFont(new Font("Railway",Font.BOLD,14));
        adharTextFild.setBounds(250,380,300,30);
        add(adharTextFild);


        seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Railway",Font.BOLD,12));
        seniorCitizen.setBounds(100,420,100,30);
        add(seniorCitizen);


        yes = new JRadioButton("YES");
        yes.setBackground(Color.WHITE);
        yes.setBounds(250,420,80,30);
        add(yes);
        ButtonGroup  seniorGroup=new ButtonGroup();
        seniorGroup.add(yes);

        no= new JRadioButton("NO");
        no.setBackground(Color.WHITE);
        no.setBounds(350,420,80,30);
        add(no);
        seniorGroup.add(no);

        existingAccount =new JLabel("Exisiting Account");
        existingAccount.setFont(new Font("Railway",Font.BOLD,14));
        existingAccount.setBounds(100,460,200,30);
        add(existingAccount);


        yes = new JRadioButton("YES");
        yes.setBackground(Color.WHITE);
        yes.setBounds(250,460,80,30);
        add(yes);
        ButtonGroup  existGroup=new ButtonGroup();
        existGroup.add(yes);

        no= new JRadioButton("NO");
        no.setBackground(Color.WHITE);
        no.setBounds(350,460,80,30);
        add(no);
        existGroup.add(no);



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
        String additionalDetails;
        String sreligion=(String)religionCombo.getSelectedItem();
        String sincome=(String) incomeCombo.getSelectedItem();
         String squalification=(String) qualificationCombo.getSelectedItem();
        String soccupation=(String) ocupationCombo.getSelectedItem();

        String scatogory=(String) catogoryCombo.getSelectedItem();
        String spanNo=panNoTextFild.getText();
        String sadharNum=adharTextFild.getText();
        String sseniorCitizion = null;
        if(yes.isSelected()){
            sseniorCitizion="YES";
        }
        else if(no.isSelected()){
            sseniorCitizion="NO";
        }
        String sexistingAccount=null;
        if(yes.isSelected()){
            sexistingAccount="YES";
        }
        else if(no.isSelected()){
            sexistingAccount="NO";
        }

        try{
            if(sreligion.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name is required");

            }
            else {
                conn c=new conn();
                String query= "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scatogory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+ spanNo +"','"+sadharNum+"','"+sseniorCitizion+"','"+sexistingAccount+"')";
                c.s.executeUpdate(query);
            }
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}

