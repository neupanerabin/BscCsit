package File_Handling;

import java.io.FileReader;
import java.io.IOException;

public class File_Read {

    public static void main(String[] args) {
    	
    	// Create an array of character
    	char[] array = new char[100];

        try {
        	// create a reader using file reader
            FileReader read = new FileReader("../Classroom/src/Hello.txt");

            // Check if reader is ready
            	 // throws boolean
            	 System.out.println("Is the data in the stream: "+ read.ready());
            
            	 // read and display the text in written file
            	 read.read(array);
            	 System.out.println(array);	// Display text inside in the file

            read.close();	// close the fileReader

        } catch (IOException e) {
            System.out.println("Unable to read.");
            e.printStackTrace();
        }

    }

}
