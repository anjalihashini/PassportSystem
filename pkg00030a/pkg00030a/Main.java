/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg00030a;
import java.sql.*;
/**
 *
 * @author anjali
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=00030a;username=Anjali;password=12345");
         System.out.println("Success");
      } 
      catch (ClassNotFoundException|SQLException e){
          System.out.println("Error");
          
      }
     }
    }
   
