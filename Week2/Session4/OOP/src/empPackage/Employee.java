package empPackage;

public class Employee {
	private String email;
    private Double pay;
    
	public Employee(String email, Double pay) {
		this.email = email;
		this.pay = pay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}
	
	public void empDetails() {
	       System.out.printf("\nEmail : %s , Pay: %,.2f",this.email,this.pay); 
	 }
	
	
	
	
    
    

}
