/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportsystem;
//immport
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anjali
 */
public class Adminn {
   
    private String UserName;
    private String Password;
    
    DBconnection ob;
    Connection con;
    
    public  Adminn(String UserName, String Password){
        
        this.UserName=UserName;
        this.Password=Password;
    }
   

   public Adminn() {
         DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
    }

   
    
    

public void LoginAdmin(String UserName,String Password){    //Admin login class
 try{
        String sql="Select username,password from Admin where username=?and password=?";
        PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,UserName);
		statement.setString(2,Password);
            ResultSet resultset=statement.executeQuery();
            
            if(resultset.next()){
                System.err.println("Login success"); //print succses msg
                
                
            }
            else{
               JOptionPane.showMessageDialog(null, "Invalid User Name or Password","Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    catch(SQLException e) {
        	System.out.println(e);
        	
        	
        }   
}
//search id=view table
public void view(JTable table,String id){
    //connection
     DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
    try{
       
        statement=con.prepareStatement("SELECT*FROM Application where id=?");
        statement.setString(1, id);
        resultSet=statement.executeQuery();
        ResultSetMetaData rsmd=(ResultSetMetaData) resultSet.getMetaData();
        int n=rsmd.getColumnCount();
        var dtm= (DefaultTableModel)table.getModel();
        
        dtm.setRowCount(0);
        while (resultSet.next()){
          Vector<Object> v =new Vector<>();
          for(int i=1;i<=n;i++){  //cols total=n
              v.add(resultSet.getString("id"));
              v.add(resultSet.getString("travel_document_type"));
              v.add(resultSet.getString("Name"));
              v.add(resultSet.getString("NIC"));
              v.add(resultSet.getString("District"));
              v.add(resultSet.getString("Address"));
              v.add(resultSet.getString("Gender"));
              v.add(resultSet.getString("Date_of_Birth"));
              v.add(resultSet.getString("Number"));
              v.add(resultSet.getString("Email"));
              v.add(resultSet.getString("Occupation"));
              v.add(resultSet.getString("Status"));
              v.add(resultSet.getString("submitDocument"));
              v.add(resultSet.getString("payment"));
              v.add(resultSet.getString("Verification"));
              v.add(resultSet.getString("PoliceReport"));
          }
          dtm.addRow(v);
        }
    }   catch (SQLException e) {
            System.err.println("SQLException:"+e.getMessage());
        } finally{
        try{
        if(resultSet !=null)resultSet.close();
        if( statement !=null) statement.close();
        if(con !=null)con.close();  
}
    catch(SQLException e){
            System.err.println("Error closing resources:"+e.getMessage());
            }
}
}
//all details view
public void viewall(JTable table){
    //connection
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
    try{
       
        statement=con.prepareStatement("SELECT*FROM Application");
        
        resultSet=statement.executeQuery();
        ResultSetMetaData rsmd=(ResultSetMetaData) resultSet.getMetaData();
        int n=rsmd.getColumnCount();
        var dtm= (DefaultTableModel)table.getModel();
        
        dtm.setRowCount(0);
        while (resultSet.next()){
          Vector<Object> v =new Vector<>();
          for(int i=1;i<=n;i++){
              v.add(resultSet.getString("id"));
              v.add(resultSet.getString("travel_document_type"));
              v.add(resultSet.getString("Name"));
              v.add(resultSet.getString("NIC"));
              v.add(resultSet.getString("District"));
              v.add(resultSet.getString("Address"));
              v.add(resultSet.getString("Gender"));
              v.add(resultSet.getString("Date_of_Birth"));
              v.add(resultSet.getString("Number"));
              v.add(resultSet.getString("Email"));
              v.add(resultSet.getString("Occupation"));
              v.add(resultSet.getString("Status"));
              v.add(resultSet.getString("submitDocument"));
              v.add(resultSet.getString("payment"));
              v.add(resultSet.getString("Verification"));
              v.add(resultSet.getString("PoliceReport"));
          }
          dtm.addRow(v);
        }
    }   catch (SQLException e) {
            System.err.println("SQLException:"+e.getMessage());
        } finally{
        try{
        if(resultSet !=null)resultSet.close();
        if( statement !=null) statement.close();
        if(con !=null)con.close();  
}
    catch(SQLException e){
            System.err.println("Error closing resources:"+e.getMessage());
            }
}
}
//edit 1 ststus
public void Edit1(String id,String Status){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
     try{  // try and catch error handle
         String sql="UPDATE Application SET Status=? WHERE id=?";    // update quary
         statement=con.prepareStatement(sql);
         statement.setString(1, Status);
         statement.setString(2, id);
         
          int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                
                System.out.println("status updated successfully.");  //print seccess
                    
                 }
             else {
                System.out.println("No rows Updated");    //error
            }
}
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());            //error
        }
       
    }


//  edir 2 verification

public void Edit2(String id,String Verification){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
     try{
         String sql="UPDATE Application SET  Verification=? WHERE id=?";
         statement=con.prepareStatement(sql);
         statement.setString(1, Verification);
         statement.setString(2, id);
         
          int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                
                System.out.println("status updated successfully.");
                    
                 }
             else {
                System.out.println("No rows Updated");
            }
}
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
    }
//edir 3 police report
public void Edit3(String id,String PoilceReport){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
     try{
         String sql="UPDATE Application SET PoliceReport=? WHERE id=?";
         statement=con.prepareStatement(sql);
         statement.setString(1, PoilceReport);
         statement.setString(2, id);
         
          int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                
                System.out.println("status updated successfully.");
                    
                 }
             else {
                System.out.println("No rows Updated");
            }
}
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
    }
//schedule date insert
public void Scheduleappoinment(String id,Date date,String time){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
    
        try {
            String sql = "INSERT INTO Schedule (id,date,time) VALUES (?, ?, ?)";
             statement = con.prepareStatement(sql);
            statement.setString(1, id);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setString(3,time);
             int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                
                System.out.println("data insert successfully.");
                   
                 }
             else {
                System.out.println("Data insertion failed!");
            }
            } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//schedule date update
public void ScheduleUpdate(String id,Date date,String time){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
        try{
            String sql="UPDATE Schedule SET date=?,time=? WHERE id=?";
         statement=con.prepareStatement(sql);
         statement.setDate(1, new java.sql.Date(date.getTime()));
         statement.setString(2, time);
         statement.setString(3, id);
         
          int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                
                System.out.println(" successfully.");
                    
                 }
             else {
                System.out.println("No rows Updated");
            }
}
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
    }
        }



     


