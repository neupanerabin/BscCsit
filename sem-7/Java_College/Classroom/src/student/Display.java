package student;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Display {
	
	Display(){
		
	}
	
	void show() {
		try {
			// create a reader using file reader
			FileReader read = new FileReader("../Classroom/src/rabin.txt");
	            Scanner reader = new Scanner(read);
	            
	            while (reader.hasNextLine()) {
	                String data = reader.nextLine();
	                System.out.println(data);
	            }
			
			read.close(); // close the fileReader

		} catch (IOException e) {
			System.out.println("Unable to read.");
			e.printStackTrace();
		}
	}

}
