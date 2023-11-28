package File_Handling;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class Buffer_Writer {

	public static void main(String[] args) {
		String data = "This is written in the buffer writer files";
		try {
			// creates a file writer
			FileWriter file = new FileWriter("../Classroom/src/bufferwriter.txt");

			// creates a buffer writer
			BufferedWriter buffer = new BufferedWriter(file);

			buffer.write(data);
			System.out.println("Written in the file successfull");
			buffer.close(); // Close the Buffer

		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e);
		}
	}

}
