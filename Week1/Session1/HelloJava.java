public class HelloJava {

    public static void main(String[] args) {
        // System.out.print("Hello Team Java, How are you doing?");
        // Primitive Types
        byte myByte=30;
        int myInt=65365463;
        float myFloat=20.200090f;
        boolean myBool=false;

        System.out.println("\nMy age is " + myByte);
        
        // Non-Primitive Types
       String firstName="Alex";
       System.out.println(firstName.toUpperCase());
       System.out.println(firstName.length());
       greet();
       greet("Andrew");
       System.out.println(evenOdd(200)); 
       System.out.println(evenOdd(201)); 
       oneTo255();
       

    }
    public static void greet(){
        System.out.println("Welcome to Java");
    }
    public static void greet(String name) {
        System.out.printf("Welcome to Java %s !!!", name);
    }
   
    public static String evenOdd(int number){
        if(number%2==0){
            return number + "  is even";
        }
        else{
            return String.format("%d is Odd" , number)  ;
        }
    }
    public static void oneTo255() {
        for(int i=1;i<=255;i++){
            System.out.println(evenOdd(i));
        }
    }
   
}
