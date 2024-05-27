package Bank_management_System;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){

        try{
             c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","9135@Herodad");
             s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
