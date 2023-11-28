package File_Handling;

import java.io.FileWriter;
import java.io.IOException;

public class Write_in_File {
	
	public static void main(String[] args) {
		
		try {
			FileWriter write = new FileWriter("../Hello.txt");
			write.write("Writing in the java files");
			write.close();
			System.out.println("File written successfully");
			
		} catch (IOException e) {
			System.out.println("Unable to create");
			e.printStackTrace();
		}
		
		
		
	}

}
