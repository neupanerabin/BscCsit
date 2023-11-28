package File_Handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaders {

	public static void main(String[] args) {

		char[] array = new char[100];

		try {
			// creates a file reader
			FileReader readFile = new FileReader("../Classroom/src/bufferwriter.txt");
			// Creates a buffer reader
			BufferedReader buffers = new BufferedReader(readFile);

			// Reads characters
			try {
				System.out.println("Data in the Stream: ");
				buffers.read(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(array);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
