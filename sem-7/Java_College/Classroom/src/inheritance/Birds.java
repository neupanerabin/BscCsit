package inheritance;

//Bird.java
public class Birds extends Animal {
	public Birds(String name) {
		super(name); // call the constructor of the superclass
	}
	
	public void fly() {
		System.out.println(name + " is flying. \n");
	}
}
