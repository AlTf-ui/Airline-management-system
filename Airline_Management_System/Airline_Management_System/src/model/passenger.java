
package model;

public class passenger {
    
    String name;
    int passportnumber;
    int age;
    String gender;

    public passenger(String name,int passportnumber,int age,String gender) {
      this.name=name;
      this.age=age;
      this.gender=gender;
        this.passportnumber = passportnumber;
       
    }

    public String getName() {
        return name;
    }

    public void settName(String name) {
        this.name = name;
    }


    public int getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(int passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getGenders() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
          return this.name + "\t" +  this.gender + "\t" + this.passportnumber + "\t" + this.age  ;
    }
}
