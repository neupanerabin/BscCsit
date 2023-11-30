package error_Handling;

import java.util.Scanner;

public class IntegerErrors {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	// Scanner input
		int num2 = 12;
		System.out.println("Enter integer value: ");
		try {
			int num = sc.nextInt();
			int result = num2 / num;
			System.out.println(result);

		} catch (ArithmeticException ex) {
			System.out.println("Arithmetic Exception: " + ex);

		} catch (Exception ex) {
			System.out.println("Error: ");
		}

	}

}
