package abstracts;

public class Vehicle_Main {

	public static void main(String[] args) {
		// create an objects
		Motorcycle bike = new Motorcycle();
		Car car = new Car();
		
		// call methods
		bike.start();
		bike.stop();
		
		car.start();
		car.stop();
		
	}

}
