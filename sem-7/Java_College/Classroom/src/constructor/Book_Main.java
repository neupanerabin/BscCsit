package constructor;

public class Book_Main {
	public static void main(String[] args) {
		
		Book bok = new Book();
		bok.show();
		
		Book book = new Book("11 Minutes", "Paulo ", 800.00);
		book.show();
		
	}

}
