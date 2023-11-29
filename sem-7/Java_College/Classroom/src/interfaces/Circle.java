package interfaces;

public class Circle implements Shape{
	
	private double radius;
	
	public Circle(double radi) {
		this.radius= radi;
	}
	

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	public double calculatePerimeter() {
        return 2 * Math.PI * radius;
	}

}
