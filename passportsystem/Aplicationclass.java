/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package passportsystem;
//import
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author anjali
 */
//application class create 
public class Aplicationclass {
    private String TypeofDocument;
    private String FullName;
    private String Nic;
    private String Distric;
    private String PermanentAddress;
    private String Gender;
    private Date selectedDate;
    private String Number;
    private String Email;
    private String job;
    private String Status;
    private String SubmitDocument;
    private String payment;
    private String Verification;
    private String PoliceReport;
    // Getter and setter methods for TypeofDocument
    public String getTypeofDocument() {
        return TypeofDocument;
    }

    public void setTypeofDocument(String TypeofDocument) {
        this.TypeofDocument = TypeofDocument;
    }

    // Getter and setter methods for FullName
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    // Getter and setter methods for Nic
    public String getNic() {
        return Nic;
    }

    public void setNic(String Nic) {
        this.Nic = Nic;
    }

    // Getter and setter methods for Distric
    public String getDistric() {
        return Distric;
    }

    public void setDistric(String Distric) {
        this.Distric = Distric;
    }

    // Getter and setter methods for PermanentAddress
    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String PermanentAddress) {
        this.PermanentAddress = PermanentAddress;
    }

    // Getter and setter methods for Gender
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    // Getter and setter methods for selectedDate
    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    // Getter and setter methods for Number
    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    // Getter and setter methods for Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Getter and setter methods for job
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // Getter and setter methods for Status
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
   
   public String getSubmitDocument() {
       return SubmitDocument;
   }
   public void setSubmitDocument(String SubmitDocument){
       this.SubmitDocument=SubmitDocument;
   }
 public String getpayment(){
     return payment;
 }
 public void setpayment(String payment){
     this.payment=payment;
 }
 public String getVerification(){
     return Verification;
 }
 public void setVerification(String Verification){
     this.Verification=Verification;
 }
 public String setPoliceReport(){
     return PoliceReport;
 }
 public void setPoliceReport(String PoliceReport){
     this.PoliceReport=PoliceReport;
 }
 
 
DBconnection ob=new DBconnection ();
 Connection con =ob.connectdb();              //connection
 
//application form data insert
public int ApplicationForm(String TypeofDocument, String FullName, String Nic, String Distric,String PermanentAddress, String Gender, Date selectedDate, String Number,String Email, String job,String SubmitDocument,String payment,String PoliceReport) {
    
    int id = -1;
    //error handeling  use try and catch
        try {
            String sql = "INSERT INTO Application (travel_document_type, Name, NIC, District, Address, Gender, Date_of_Birth, Number, Email, Occupation, submitDocument,payment,PoliceReport) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
            
            statement.setString(1, TypeofDocument);
            statement.setString(2, FullName);
            statement.setString(3, Nic);
            statement.setString(4, Distric);
            statement.setString(5, PermanentAddress);
            statement.setString(6, Gender);
            statement.setDate(7, new java.sql.Date(selectedDate.getTime()));
            statement.setString(8, Number);
            statement.setString(9, Email);
            statement.setString(10, job);
            
            statement.setString(11, SubmitDocument);
            statement.setString(12, payment);
            
            statement.setString(13,PoliceReport);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                
                var generatedKeys = statement.getGeneratedKeys();
                 if(generatedKeys.next()){
                     id = generatedKeys.getInt(1);
                 }
            } else {
                System.out.println("Data insertion failed!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return id;
    }
//check details auto display
public void checkDetails(JTextField ii,JTextField st,JTextField dt,JTextField tm){
    DBconnection ob=new DBconnection ();
         Connection con =ob.connectdb();
      PreparedStatement statement = null;
        ResultSet resultSet=null;
    try{          // innerr join application and schedule 
       String sql = "SELECT Application.Status, Schedule.date, Schedule.time FROM Application INNER JOIN Schedule ON Application.id = Schedule.id";

          statement = con.prepareStatement(sql);    
        resultSet=statement.executeQuery();
        if(resultSet.next()){
         //ii.setText(resultSet.getString("id"));
         st.setText(resultSet.getString("status"));
         dt.setText(resultSet.getString("date"));
         tm.setText(resultSet.getString("time"));
        }
        else{
           ii.setText("");
           st.setText("");
           dt.setText("");
           tm.setText("");
        }
    }
    catch(SQLException e){
        System.out.println("Error: " + e.getMessage());
    }
}

/*
public void checkDetails(JTextField ii, JTextField st, JTextField dt, JTextField tm, String enteredId) {
    DBconnection ob = new DBconnection();
    Connection con = ob.connectdb();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        String sql = "SELECT Schedule.id, checkDetails.status, Schedule.date, Schedule.time " +
                     "FROM Schedule " +
                     "INNER JOIN checkDetails ON Schedule.id = checkDetails.id " +
                     "WHERE Schedule.id = ?";

        statement = con.prepareStatement(sql);
        statement.setString(1, enteredId); // Set the parameter (enteredId) in the query
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Populate text fields with retrieved data
            ii.setText(resultSet.getString("id"));
            st.setText(resultSet.getString("status"));
            dt.setText(resultSet.getString("date"));
            tm.setText(resultSet.getString("time"));
        } else {
            // Clear text fields if no matching record found
            ii.setText("");
            st.setText("");
            dt.setText("");
            tm.setText("");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

 */   
           
}


