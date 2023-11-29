package interfaces;

public class Main {
	public static void main(String[] args) {
		
		Circle circle = new Circle(5.0);
		Rectangle rectangle = new Rectangle(7.0, 6.0);
		
		System.out.println("\nCircle Area:  "+ circle.calculateArea());
		System.out.println("Circle Perimeter:  " + circle.calculatePerimeter());

        System.out.println("\nRectangle Area:  " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter:  " + rectangle.calculatePerimeter());
    
		
	}

}
