/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportsystem;

//import
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author anjali
 */
//create application class
public class ApplicantClass {
    
    private Login login;
    private String UserName;
    private String Password;
    private String Email;
    private String Number;
    
public ApplicantClass (String UserName,String Password,String Email,String Number){
    this.UserName=UserName;
    this.Password=Password;
    this.Email=Email;
    this.Number=Number;
}
public ApplicantClass(Login loginInstance,String UserName,String Password){
    this.login=loginInstance;
    this.UserName=UserName;
    this.Password=Password;  
}


    



DBconnection ob=new DBconnection ();
 Connection con =ob.connectdb();      // connection
 

//registretion fromm insert data
public int RegisterUser(String UserName,String Password,String Email,String Number){
    
    int id = -1;
    
    try {
		String sql="INSERT INTO Applicant (username,password,email,contact_number)VALUES (?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                
		statement.setString(1,UserName);
		statement.setString(2,Password);
		statement.setString(3,Email);
		statement.setString(4,Number);
		
		
		
		
		int rowsInserted = statement.executeUpdate();
                
                
		if (rowsInserted > 0) {
		 System.out.println("Data inserted successfully!");
                 
                 var generatedKeys = statement.getGeneratedKeys();
                 if(generatedKeys.next()){
                     id = generatedKeys.getInt(1);
                 }
		}
		else {
		 System.out.println("Data insertion Failed!");
		}
		
		
		}
        catch(SQLException e) {
        	System.out.println(e);
        	
        	
        }
    return id;
}

//login page user
public void LoginUser(String username,String password){
    try{
        String sql="Select username,password from Applicant where username=?and password=?";
        PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,UserName);
		statement.setString(2,password);
            ResultSet resultset=statement.executeQuery();
            
            if(resultset.next()){
                System.err.println("Login success");
                
                Aplication aplication=new  Aplication();
                aplication.setVisible(true);
                
                
                login.dispose();
            }
            else{
               JOptionPane.showMessageDialog(null, "Invalid User Name or Password","Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    catch(SQLException e) {
        	System.out.println(e);
        	
        	
        }   
            
    
}
}



                    

