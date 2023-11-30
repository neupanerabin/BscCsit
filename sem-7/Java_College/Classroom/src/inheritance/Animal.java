package inheritance;

//Animal.java
public class Animal {
//common attributes of all animals
	protected String name;

//constructor
	public Animal(String name) {
		this.name = name;
	}

//common behaviors of all animals
	public void eat() {
		System.out.println(name + " is eating.");
	}

	public void sleep() {
		System.out.println(name + " is sleeping.");
	}
}
