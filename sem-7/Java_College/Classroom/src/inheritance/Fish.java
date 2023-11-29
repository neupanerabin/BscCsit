package inheritance;

public class Fish extends Animal {
	// specific attribute of fish
	protected boolean scales;

	// constructor
	public Fish(String name, int age, double weight, boolean scales) {
		super(name, age, weight); // call the constructor of the superclass
		this.scales = scales;
	}

	// specific behavior of fish
	public void breathe() {
		System.out.println(name + " is breathing with gills.");
	}

	public void swim() {
		System.out.println(name + " is swimming.");
	}
}