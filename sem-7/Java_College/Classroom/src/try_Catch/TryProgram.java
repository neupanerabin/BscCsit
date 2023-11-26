package try_Catch;

public class TryProgram {

	public static void main(String[] args) {

		int i = 40, j = 0;
		int num[] = new int[3];

		try {

			int k = i / j;
			System.out.println(k);
			System.out.println(num[66]);

		} catch (ArithmeticException ex) {
			System.out.println("Arithmetic exception");
		} 
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.print("Array error");
		}
		catch (Exception ex) {
			System.out.println("Exception error");
		}
		

	}

}
