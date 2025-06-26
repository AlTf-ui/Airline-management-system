
package model;

public class reservation {
     String flightnumber;
    
    String passengernumber;

    public reservation(String flightnumber, String passengernumber) {
        this.flightnumber = flightnumber;
        
        this.passengernumber = passengernumber;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

  

    public String getPassengernumber() {
        return passengernumber;
    }

    public void setPassengernumber(String passengernumber) {
        this.passengernumber = passengernumber;
    }

    @Override
    public String toString() {
return this.flightnumber + "\t" + this.passengernumber;
    } 
}
