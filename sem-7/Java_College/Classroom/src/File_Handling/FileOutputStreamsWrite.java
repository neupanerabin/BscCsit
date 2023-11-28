package File_Handling;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileOutputStreamsWrite {

	public static void main(String[] args) {

		String data = "This is a line of text written in inputStream files.";

		try {
			// Creates a FileOutputStream
			FileOutputStream file = new FileOutputStream("../Classroom/src/writestream.txt");

			// Creates an OutputStreamWriter
			OutputStreamWriter output = new OutputStreamWriter(file);

			// Writes string to the file
			output.write(data);
			System.out.println("File Written Successfully");
			// Closes the writer
			output.close(); // close outputStream
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}

}
