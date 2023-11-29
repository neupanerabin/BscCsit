package inheritance;

//Mammal.java
public class Mammal extends Animal {
//specific attribute of mammals
	protected boolean fur;

//constructor
	public Mammal(String name, int age, double weight, boolean fur) {
		super(name, age, weight); // call the constructor of the superclass
		this.fur = fur;
	}

//specific behavior of mammals
	public void breathe() {
		System.out.println(name + " is breathing with lungs.");
	}
}
