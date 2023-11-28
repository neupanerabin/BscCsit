package File_Handling;

import java.io.FileWriter;
import java.io.IOException;

public class Write_in_File {
	
	public static void main(String[] args) {
		
		try {
			// file path
			FileWriter write = new FileWriter("../Classroom/src/Hello.txt");
			
			write.write("Writing in the java files");	// Write inside in the file
			write.close();	// To close the writer
			System.out.println("File written successfully");
			
		} catch (IOException e) {
			System.out.println("Unable to create");
			e.printStackTrace();
		}
		
		
		
	}

}
