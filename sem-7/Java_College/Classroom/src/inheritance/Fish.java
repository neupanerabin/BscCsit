package inheritance;

public class Fish extends Animal {
	// constructor
	public Fish(String name) {
		super(name);
	}
	// specific behavior of fish
	public void breathe() {
		System.out.println(name + " is breathing with gills.\n");
	}
}