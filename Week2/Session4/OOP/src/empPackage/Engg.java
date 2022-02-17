package empPackage;

public class Engg extends Employee{
	
	private String project;

	public Engg(String email, Double pay, String project) {
		super(email, pay);
		this.project = project;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	public void enggInfo() {
		this.empDetails();
		System.out.println("\nI am working on Project:" + this.project);
		
	}

}
