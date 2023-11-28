package File_Handling;

import java.io.InputStreamReader;
import java.io.FileInputStream;

// Input Stream is the reader 

public class FileInputStreamsRead {

	public static void main(String[] args) {

		// Create an array of characters

		char[] array = new char[100];

		try {
			// Create FileInputStream
			FileInputStream fileInputStream = new FileInputStream("../Classroom/src/writestream.txt");

			// InputStram Reader
			InputStreamReader inputStream = new InputStreamReader(fileInputStream);

			// Read characters from the file
			inputStream.read(array);
			System.out.println("Data in the stream");
			System.out.println(array);
			inputStream.close(); // close the stream
		} catch (Exception ex) {
			ex.getStackTrace();
		}

	}

}
