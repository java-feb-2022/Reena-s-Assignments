import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal() {
        int sum=0;
        for(int i=1;i<=10;i++){
            sum+=i;
        }
        return sum;
        
    }
    // Ninja Bonus - Method overloading
    public int getStreakGoal(int numWeeks) {
        int sum=0;
        for(int i=1;i<=numWeeks;i++){
            sum+=i;
        }
        return sum;
    }
    public double getOrderTotal(double[] prices) {
        double total=0;
        for (double d : prices) {
            total+=d;
            
        }
        return total;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
    }
    public void addCustomer(ArrayList<String> customers){
        String userName = System.console().readLine();
        System.out.printf("Hello %s, there are %d customers are in front of you",userName, customers.size());
        customers.add(userName);
        for (String customer : customers) {
            System.out.println(customer+"\n");
        }
    }
    


    
}
