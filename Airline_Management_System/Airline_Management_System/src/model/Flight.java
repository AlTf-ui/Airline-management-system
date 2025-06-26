
package model;

public class Flight {
      
    String flightnumber;
    String from;
    String to;
    int pssn;

    public Flight(String flightnumber, String from, String to,int pssn) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to=to;
      this.pssn=pssn;
    }
public int getpssn(){
return pssn;
}
public void setpssn(int pssn){
this.pssn=pssn;

}
    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

  

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
String out = "";
        out = this.flightnumber+ ",'" + this.from + "','" + this.to;
        return out;    }
    
}
