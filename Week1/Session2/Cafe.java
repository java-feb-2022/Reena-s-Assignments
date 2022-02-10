import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cafe {

    public void chaiLatte() {
        System.out.println("Enjoy your Chai Latte!!");
    }
    public void americano(String customer) {
        System.out.printf("Enjoy your americano, %s\n", customer);
        
    }
    // Array 
    public void buildArray() {
        int[] numbers=new int[10];
        // 0 1 2 
        // Create an array(1-10) and print it's values
        // numbers[0]=1;
        // numbers[1]=2;
       for (int i = 0; i < numbers.length; i++) {
           numbers[i]=i+1;
       }
       System.out.println(numbers[0]);
        //    For Each
        for(int i : numbers) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(numbers));

        // String Arrays
        String[] menu={"Caramel Macchiato","Hot Chocolate","Frappuccino"};
        try{
        menu[3]="Kiwi Refresher";
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Oh dear! you need more practice");
        }
        System.out.println(Arrays.toString(menu));
    
    }

    // ArrayList - Build Customer List 
    public int buildCustomerArrayList() {
        ArrayList<String> customers=new ArrayList<>();
        customers.add("Carlos");
        customers.add("Taeko");
        customers.add("Robert");
        customers.add("Kyeongeun");
        customers.remove(2);
        System.out.println(customers);
        ArrayList<Float> numbers=new ArrayList<>();
        return customers.size();
    }
    // Hashmaps
    public void customerFavorites() {
        HashMap<String,String> favorites=new HashMap<String,String>();
        favorites.put("Reena", "Green Tea");
        favorites.put("Kyeongeun", "Caramel Frappuccino");
        favorites.put("Liam", "Tap Water");
        favorites.put("Carlos", "Hot Chocolate");
        favorites.put("Phong", "Coffe");
        favorites.put("Lisa","Gin and Soda");
        favorites.put("William", "Drip Coffee");
        favorites.put("Robert", "Sweet Tea");
        favorites.put("Darius","Espresso");
        favorites.put("Daniel", "Refresher");
        favorites.put("Andrew", "MoutnainDew");
        favorites.put("Michael", "cappuccino");
        favorites.put("David","Hot chocolate");
        favorites.put("Alex", "Mocha");
        favorites.put("Brendan","Mocha");
        favorites.put("Basha", "Capuccino");

        System.out.println(favorites.get("Brendan"));
        for (String key : favorites.keySet() ) {
            // System.out.println(key + ":" + favorites.get(key));
            System.out.printf("%s favorite drink is %s\n", key,favorites.get(key));
        }









        











        
    }
}
