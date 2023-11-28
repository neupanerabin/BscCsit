package File_Handling;

import java.io.FileInputStream;
import java.io.IOException;

public class File_Read {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream read = new FileInputStream("../Hello.txt");
			
			System.out.println("File read successfully");
			
			
			read.close();
			
		} catch (IOException e) {
			System.out.println("Unable to read");
			e.printStackTrace();
		}
		
		
		
	}

}
