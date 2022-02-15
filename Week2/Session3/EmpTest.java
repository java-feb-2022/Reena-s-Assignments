import java.util.ArrayList;

public class EmpTest {
    public static void main(String[] args) {
        System.out.println("In Emp Test Class");
        Employee lisa=new Employee();
        // lisa.email="lisa@cafe.com";
        lisa.setEmail("lisa@cafe.com");
        lisa.setPay(300000);

        
        Employee michael =new Employee("michael@cafe.com", 8500000);
        Employee alex=new Employee("alex.cafe.com", 200000);

        // System.out.println(michael.getEmail() + michael.getPay());
        michael.empDetails();
        lisa.setPay(400000);
        lisa.empDetails();
        michael.bonus();
        michael.empDetails();
        alex.bonus(800);
        Employee carlos=new Employee("Carlos@cafe.com",4500000);
        System.out.printf("\nNo of total emps: %d", Employee.getNoOfEmps());


        ArrayList<String> lisaSkills=new ArrayList<>();
        lisaSkills.add("Excel");
        lisaSkills.add("Java");
        lisaSkills.add("Python");
        lisaSkills.add("How to have fun!!!");

        lisa.setSkills(lisaSkills);
        lisa.empDetails();

        ArrayList<String> carlosSkills=new ArrayList<>();
        carlosSkills.add("Play Music");
        carlosSkills.add("Serve");
        carlosSkills.add("Java");
        carlosSkills.add("How to have fun with Java peers!!!");

        carlos.setSkills(carlosSkills);
        carlos.empDetails();
              

    }

       
}