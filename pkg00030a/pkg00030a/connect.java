/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg00030a;
import java.sql.*;

/**
 *
 * @author anjali
 */
public class connect {
    Connection conn;
       
     public void connectdb(){
     try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
         conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=00030a;username=Anjali;password=12345"); 
          System.out.println("success");
      } 
      catch (ClassNotFoundException|SQLException e){
          System.out.println("Error");
          
      }
     }
      public void insertData(int Id,String upasswrd,String name,String fname,String Lname,String email,String join,int num,String system,String member,String date,String time){
        try{
            Statement stmt =conn.createStatement( );
            stmt.execute("INSERT INTO employee00030(Id,Userpassword,Name,Fristname,Lastname,Email,Datajoined,Mobilenumber,Systemactivity,Staffmember,Logindate,Logintime )values("+Id+",'"+upasswrd+"','"+name+"','"+fname+"','"+Lname+"','"+email+"','"+join+"',"+num+",'"+system+"','"+member+"','"+date+"','"+time+"');");
            System.out.println("insert success");
        }
        
        catch(SQLException e){
            System.out.println("Insert failed");
        }
    } 
   public void deleteData(int Id) {
       try{
           Statement stmt=conn.createStatement();
            stmt.execute("DELETE FROM employee00030 WHERE Id="+Id+";");
       } 
       
       catch(SQLException e){
           System.out.println("delete failed");
       }
       
   }    
      
 public void updateData(int Id,int num){
       
       try{
            Statement stmt=conn.createStatement();
           stmt.executeUpdate("update  employee00030 SET Mobilenumber="+num+" WHERE Id="+Id+";");
           
       }
    catch(SQLException e){
        System.out.println("update faild");   
       }
       
     }
     public  void searchData(int Id){
     try{
         Statement stmt = conn.createStatement();
         String search=("SELECT Id,Userpassword,Name,Fristname,Lastname,Email,Datajoined,Mobilenumber,Systemactivity,Staffmember,Logindate,Logintime From employee00030 WHERE Id="+Id+";");
          ResultSet rs= stmt.executeQuery(search);
          while(rs.next()){
             System.out.println("Id:"+rs.getInt("Id"));
             System.out.println("Userpassword :"+rs.getString("Userpassword"));
             System.out.println("Name :"+rs.getString("Name"));
             System.out.println("Fristname :"+rs.getString("Fristname"));
             System.out.println("Lastname :"+rs.getString("Lastname"));
             System.out.println("Email :"+rs.getString("Email"));
             System.out.println("Datajoined :"+rs.getString("Datajoined"));
             System.out.println("Mobilenumber :"+rs.getInt("Mobilenumber"));
             System.out.println("Systemactivity :"+rs.getString("Systemactivity"));             
             System.out.println("Staffmember:"+rs.getString("Staffmember"));
             System.out.println("Logindate :"+rs.getString("Logindate"));
             System.out.println("Logintime :"+rs.getString("Logintime"));
             
         }
     } 
        catch(SQLException e){
        System.out.println("search failed");
        }        
    
  }

      public void insertDataa(int Id,String upasswrd,String name,String fname,String Lname,String email,String join,int num,String system,String member,String date,String time){
        try{
            Statement stmt =conn.createStatement( );
            stmt.execute("INSERT INTO supplier00030(Id,Userpassword,Name,Fristname,Lastname,Email,Datejoined,Mobilenumber,SystemActivity,Staffmember,Logindate,Logintome )values("+Id+",'"+upasswrd+"','"+name+"','"+fname+"','"+Lname+"','"+email+"','"+join+"',"+num+",'"+system+"','"+member+"','"+date+"','"+time+"');");
            System.out.println("insert success");
        }
        catch(SQLException e){
            System.out.println("Insert failed");
        }
    } 
     
      
      public void deleteDataa(int Id) {
       try{
           Statement stmt=conn.createStatement();
            stmt.execute("DELETE FROM supplier00030 WHERE Id="+Id+";");
                   
       }
       catch(SQLException e){
           System.out.println("delete failed");
       }
       
   } 
      
       public void updateDataa(int Id,String name){
       
       try{
            Statement stmt=conn.createStatement();
           stmt.executeUpdate("update  supplier00030 SET Name='"+name+"' WHERE Id="+Id+";");
           
       }
    catch(SQLException e){
        System.out.println("update failed");   
       }
       
     }
       
       public  void searchDataa(int Id){
     try{
         Statement stmt = conn.createStatement();
         String search=("SELECT Id,Userpassword,Name,Fristname,Lastname,Email,Datejoined,Mobilenumber,SystemActivity,Staffmember,Logindate,Logintome From supplier00030 WHERE Id="+Id+";");
         ResultSet rs= stmt.executeQuery(search);
          while(rs.next()){ System.out.println("Id:"+rs.getInt("Id"));
             System.out.println("Userpassword :"+rs.getString("Userpassword"));
             System.out.println("Name :"+rs.getString("Name"));
             System.out.println("Fristname :"+rs.getString("Fristname"));
             System.out.println("Lastname :"+rs.getString("Lastname"));
             System.out.println("Email :"+rs.getString("Email"));
             System.out.println("Datejoined :"+rs.getString("Datejoined"));
             System.out.println("Mobilenumber :"+rs.getInt("Mobilenumber"));
             System.out.println("SystemActivity :"+rs.getString("SystemActivity"));             
             System.out.println("Staffmember:"+rs.getString("Staffmember"));
             System.out.println("Logindate :"+rs.getString("Logindate"));
             System.out.println("Logintome :"+rs.getString("Logintome"));
             
         }
     } 
        catch(SQLException e){
        System.out.println("search failed");
        }        
    
  }
       
       
       
       
       
      public void itinsertData(int Itemid,String Category,int Unitid,String Name,int Price,String Image){
        try{
            Statement stmt =conn.createStatement( );
            stmt.execute("INSERT INTO Item00030(Itemid,Category,Unitid,Name,Price,Image)VALUES("+Itemid+",'"+Category+"',"+Unitid+",'"+Name+"',"+Price+",'"+Image+"');");
            System.out.println("insert success");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    } 
            
      
      
       public void itedeleteDataa(int Itemid) {
       try{
           Statement stmt=conn.createStatement();
            stmt.execute("DELETE FROM Item00030 WHERE  Itemid="+Itemid+";");
                   
       }
       catch(SQLException e){
           System.out.println("delete failed");
       }
       
   } 
       
        public void iteupdateDataa(int Itemid,String Name){
       
       try{
            Statement stmt=conn.createStatement();
           stmt.executeUpdate("update  Item00030 SET Name='"+Name+"' WHERE Itemid="+Itemid+";");
           
       }
    catch(SQLException e){
        System.out.println("update failed");   
       }
       
     }
        
          public  void itesearchDataa(int Itemid){
     try{
         Statement stmt = conn.createStatement();
         String search=("SELECT Itemid,Category,Unitid,Name,Price,Image From Item00030 WHERE Itemid="+Itemid+";");
         ResultSet rs= stmt.executeQuery(search);
          while(rs.next()){ 
             System.out.println("Itemid:"+rs.getInt("Itemid"));
             System.out.println("Category :"+rs.getString("Category"));
             System.out.println("Unitid:"+rs.getString("Unitid"));
             System.out.println("Name :"+rs.getString("Name"));
             System.out.println("Price :"+rs.getString("Price"));
             System.out.println("Email :"+rs.getString("Email"));
             System.out.println("Image:"+rs.getString("Image"));
             
             
         }
     } 
        catch(SQLException e){
        System.out.println("search failed");
        }        
    
  }
       
        
      public void OrdinsertDataa(int Id,String Customername,String Itemname,int ItemQuntity,int Dateoforder, String Time){
        try{
            Statement stmt =conn.createStatement( );
            stmt.execute("INSERT INTO order0030(Id,Customername,Itemname,ItemQuntity,Dateoforder,Time )values("+Id+",'"+Customername+"','"+Itemname+"',"+ItemQuntity+","+Dateoforder+",'"+Time+"');");
            System.out.println("insert success");
        }
        catch(SQLException e){
            System.out.println("Insert failed");
        }
    }   
          
           public void ordedeleteDataa(int Id) {
       try{
           Statement stmt=conn.createStatement();
            stmt.execute("DELETE FROM order00030 WHERE  Id="+Id+";");
            System.out.println("Delete Success");
                   
       }
       catch(SQLException e){
           System.out.println("Delete Failed");
       
   } 
       
          
           } 
           
             public  void ordesrearchDataa(int Id){
     try{
         Statement stmt = conn.createStatement();
         String search="SELECT Id,Customername,Itemname,ItemQuntity,Dateoforder From order00030  WHERE Id="+Id+";";
         ResultSet rs= stmt.executeQuery(search);
          while(rs.next()){ 
             System.out.println("Id:"+rs.getInt("Id"));
             System.out.println("Customername :"+rs.getString("Customername"));
             System.out.println("Itemname:"+rs.getString("Itemname"));
             System.out.println("Itemquntity :"+rs.getInt("ItemQuntity"));
             System.out.println("Dateoforder :"+rs.getInt("Dateoforder"));
             
   
    
  }
           } 
        catch(SQLException e){
        System.out.println(e.getMessage());
        }        
    
  }
}

         
         
         



