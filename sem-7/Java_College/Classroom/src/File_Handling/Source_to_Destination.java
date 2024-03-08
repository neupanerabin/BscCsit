package File_Handling;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class Source_to_Destination {

	public static void main(String[] args) {

		try {
			// Read data from the source file
			BufferedReader reader = new BufferedReader(new FileReader("../Classroom/src/bufferwriters.txt"));

			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
			}
			reader.close();
			String data = stringBuilder.toString();

			// Creates a FileOutputStream
			FileOutputStream file = new FileOutputStream("../Classroom/src/destination.txt");

			// Creates an OutputStreamWriter
			OutputStreamWriter output = new OutputStreamWriter(file);

			// Writes string to the file
			output.write(data);
			System.out.println("\n File Written Successfully");

			// Closes the writer
			output.close(); // close outputStream
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
