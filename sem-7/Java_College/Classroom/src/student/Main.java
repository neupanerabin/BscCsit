package student;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1: Enter the Student info");
		System.out.println("Press 2: to display the Student info. ");
		
		Written writen = new Written();	// Create objects of written class
		Display display = new Display();	// create objects of display
		
		int a = sc.nextInt();
		System.out.println(" \t");
		switch(a) {
		case 1:
			writen.write();
			writen.writtens();
			break;
		case 2:
			display.show();
			break;
		}
		
		
	}



}
