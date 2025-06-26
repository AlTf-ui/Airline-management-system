
package model;

public class pilot {
     private int SSN;
    private String Pname;
    private int PAge;

    public pilot(int SSN, String Pname, int PAge) {
        this.SSN = SSN;
        this.Pname = Pname;
        this.PAge = PAge;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public int getPAge() {
        return PAge;
    }

    public void setPAge(int PAge) {
        this.PAge = PAge;
    }

    @Override
    public String toString() {
        String out = "";
        out = this.SSN + ",'" + this.Pname + "','" + this.PAge;
        return out;
    }
}
