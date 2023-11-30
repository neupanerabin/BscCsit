package inheritance;

public class Main {
	public static void main(String[] args) {
		// Creating objects 
		Mammal mam = new Mammal("Human");
		Birds sparrow = new Birds("Sparrow");
		Fish goldfish = new Fish("gold fish");
		
		mam.eat();
		mam.sleep();
		mam.breathe();
		
		sparrow.eat();
		sparrow.sleep();
		sparrow.fly();
		
		goldfish.eat();
		goldfish.sleep();
		goldfish.breathe();
		
	}

}
