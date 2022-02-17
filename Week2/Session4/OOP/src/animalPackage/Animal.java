package animalPackage;

public abstract class Animal implements Living {

	public void sleep() {
		System.out.println("I like to sleep a LOT!!!");
	}
	
	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("I can breath O2");
		
	}
	public abstract void eat();
	
	
}
