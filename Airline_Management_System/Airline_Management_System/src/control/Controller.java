package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Flight;
import model.passenger;
import model.pilot;

public class Controller {

    Connection connection;
    Statement statement;

    private void connect() throws SQLException {
       connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/airline_mangement_system_sql", "root", "");
        statement = connection.createStatement();
    }

    private void disconnect() throws SQLException {
        statement.close();
        connection.close();
    }

    public void Addpilot(int ssn, String Pname, int PAge ){
        String query="INSERT into pilots values("+ ssn + " ,'"+Pname+"',"+PAge+")";
        try {
            connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void Addpassengers (int passportnumber, String name, int age , char gender){
        String query = "insert into pilots values ("+ passportnumber +","+ name +","+ age+","+gender+")";
            try{
                connect();
            statement.executeUpdate(query);
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public ArrayList<String> getallcity() {

        ArrayList<String> ALLCITY = new ArrayList<>();
        
      String query="SELECT DEPARTURECITY FROM flights";
        try {
            connect();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                    
                    
            String city=rs.getString("DEPARTURECITY");
            ALLCITY.add(city);
            
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ALLCITY;
    }

    public Flight getflightBycity(String city) {
        Flight flight = null;
        
       String query = "SELECT * FROM flights WHERE DEPARTURECITY = '" + city + "'";
        
        try {
            connect();
            ResultSet rs = statement.executeQuery(query);
if(rs.next()){
String FLIGHTNUMBER=rs.getString("FLIGHTNUMBER");
String DEPARTURECITY=rs.getString("DEPARTURECITY");
String ARRIVALCITY= rs.getString("ARRIVALCITY");
int PSSN=rs.getInt("PSSN");

flight = new Flight(FLIGHTNUMBER, DEPARTURECITY, ARRIVALCITY, PSSN);

}
     
            
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return flight;
    }

  
    public passenger getpassengerinfo(int passportnumber){
    passenger ps=null;
    String query="SELECT * FROM `passenger` WHERE passportnumber='"+passportnumber+"'";
    try{
        connect();
    ResultSet rs = statement.executeQuery(query);
    
    if(rs.next()){
    String name = rs.getString("NAME");
      int pn=rs.getInt("passportnumber");
    int age = rs.getInt("AGE");
    String gender= rs.getString("GENDER");
    
    
    
    ps = new passenger(name, passportnumber, age, gender);
    }
    
    
    }
   
    
    catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
        return ps ;
   
        
    }
    public void updatepassenger(String name, int passportnumber, int age, String gender){
     String query = "UPDATE passenger SET NAME='"+ name + "', AGE =" + age +" ,GENDER = '"+ gender + "'" + " WHERE passportnumber = "+ passportnumber;
         System.out.println(query);
         
               try {
            connect();
            statement.executeUpdate(query);
            disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
     
     }
    }}

