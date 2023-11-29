package File_Handling;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class Buffer_using_ForLoop {

	public static void main(String[] args) {
		
		String[] stringArray = {"Apple", "Banana", "Orange", "Grapes", "Mango"};

		try {
			// creates a file writer
			FileWriter file = new FileWriter("../Classroom/src/bufferwriters.txt");

			// creates a buffer writer
			BufferedWriter buffer = new BufferedWriter(file);
			
			for(int i =0; i<stringArray.length; i++) {
				buffer.write(stringArray[i]+"\n");

			}

			System.out.println("Written in the file successfull");
			buffer.close(); // Close the Buffer

		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e);
		}
	}

}
