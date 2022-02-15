import java.util.ArrayList;

public class Employee {

    // Access modifiers
    // Class- Attributes
    private String email;
    private float pay;
    private ArrayList<String> skills=new ArrayList<>();
    
    // Static member 
    private static int noOfEmps=0;
    
    // Constructors
    public Employee(){
            noOfEmps++;
    }
    public Employee(String email,float pay){
        this.email=email;
        this.pay=pay;
        noOfEmps++;
    }

    // Accessors/getters & Mutators/setters
    public String getEmail() {
        return email;
    }
    public float getPay() {
        return pay;
    }
    public ArrayList<String> getSkills() {
        return skills;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPay(float pay) {
        this.pay = pay;
    }
    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
  // Static Method 
    public static int getNoOfEmps() {
        return noOfEmps;
    }
    // Class methods
    public void empDetails() {
        System.out.printf("\nEmp Email: %s , Emp Pay: %.2f, \n Skills: %s", this.email,this.pay, this.skills);
    }
    // Polymorphisum -  Method Overloading - polymorphism
    public void bonus(){
        this.pay+=200;
    }
    public void bonus(float bonusAmount) {
        this.pay+=bonusAmount;
        
    }
    
   
 
  


}

