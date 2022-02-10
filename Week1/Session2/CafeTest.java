public class CafeTest {
    public static void main(String[] args) {
        Cafe myCafe=new Cafe();
        myCafe.chaiLatte();
        myCafe.americano("Robert");
        myCafe.americano("Daniel");
        myCafe.americano("Will");
        // Array 
        myCafe.buildArray();
        // ArrayList
        System.out.println(myCafe.buildCustomerArrayList());
        // Hashmap
        myCafe.customerFavorites();



        
        
    }
    
}
