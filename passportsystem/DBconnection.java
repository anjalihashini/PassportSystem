/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportsystem;
import java.sql.*;

/**
 *
 * @author anjali
 */
public class DBconnection {
    private String username;
    private String pwd;
    private String hostname;
    private String dbName;
		   
 public DBconnection () {
	this.username="root";
	this.pwd="sanjana1009";
	this.hostname="localhost";
	this.dbName="PassportSystem";
 }

 Connection con=null;
 public Connection connectdb(){
   
try{
        
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PassportSystem","root","sanjana1009"); //connection set
          return con;
      } 
      catch (SQLException e){
          return con;
          
      }
     }
}

 
    
     
 
   

  