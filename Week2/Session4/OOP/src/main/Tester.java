/**
 * 
 */
package main;

import animalPackage.*;
import empPackage.Employee;
import empPackage.Engg;

public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Team Java!!");
		
		Employee phong=new Employee("phong@cafe.com", 3500000.45);
		phong.empDetails();
		
		Engg kc=new Engg("kc@cafe.com", 2500000.20, "Make Banana Smoothie");
		kc.enggInfo();
		
//		Animal Class 
//		Animal lion=new Animal();
		Lion mufasa=new Lion();
		mufasa.eat();
		mufasa.sleep();
		mufasa.breath();
		
		Rabbit bugs=new Rabbit();
		bugs.sleep();
		bugs.eat();
		
		Tree newTree=new Tree();
		newTree.reproduce();
		
	}

}
