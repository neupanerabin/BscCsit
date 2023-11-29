package inheritance;

//Animal.java
public class Animal {
//common attributes of all animals
	protected String name;
	protected int age;
	protected double weight;

//constructor
	public Animal(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

//common behaviors of all animals
	public void eat() {
		System.out.println(name + " is eating.");
	}

	public void sleep() {
		System.out.println(name + " is sleeping.");
	}

	public void move() {
		System.out.println(name + " is moving.");
	}
}
