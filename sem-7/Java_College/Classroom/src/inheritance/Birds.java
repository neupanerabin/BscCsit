package inheritance;

//Bird.java
public class Birds extends Animal {
//specific attribute of birds
	protected boolean feathers;

//constructor
	public Birds(String name, int age, double weight, boolean feathers) {
		super(name, age, weight); // call the constructor of the superclass
		this.feathers = feathers;
	}

//specific behavior of birds
	public void breathe() {
		System.out.println(name + " is breathing with air sacs.");
	}

	public void fly() {
		System.out.println(name + " is flying.");
	}
}
