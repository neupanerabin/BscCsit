package File_Handling;

import java.io.File;

public class File_Write {

	public static void main(String[] args) {

		File file = new File("../FirstFile");	// Write into file

		// try catch used
		try {
			// condition checked 
			if (file.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File is not created ");

			}

		} catch (Exception ex) {
			System.out.println("Exception");
		}

	}

}
