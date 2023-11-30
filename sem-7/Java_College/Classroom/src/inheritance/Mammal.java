package inheritance;

//Mammal.java
public class Mammal extends Animal {
//constructor
	
	public Mammal(String name) {
		super(name);
	}

//specific behavior of mammals
	public void breathe() {
		System.out.println(name + " is breathing with lungs.\n");
	}
}
