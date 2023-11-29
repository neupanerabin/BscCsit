package File_Handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Buffer_Read_Using_For {

	public static void main(String[] args) {

		// char[] array = new char[100];

		try {
			// creates a file reader
			FileReader readFile = new FileReader("../Classroom/src/bufferwriters.txt");
			// Creates a buffer reader
			BufferedReader buffers = new BufferedReader(readFile);

			// Reads characters
			try {
				System.out.println("Data in the Stream: ");

				int charRead;
				while ((charRead = buffers.read()) != -1) {
					System.out.print((char) charRead);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
