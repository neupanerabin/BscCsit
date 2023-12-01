package student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Written {

	void write() {

		try {
			// File writer create
			FileWriter file = new FileWriter("../Classroom/src/rabin.txt");
			BufferedWriter buffer = new BufferedWriter(file);

			buffer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writtens() {
		Scanner sc = new Scanner(System.in);

		try {
			// create a reader using file reader
            BufferedWriter writer = new BufferedWriter(new FileWriter("../Classroom/src/rabin.txt", true));

			System.out.println("Enter the number of data you want to enter: ");
			int num = sc.nextInt();
			
			for(int i=0;i<num;i++) {
				System.out.print("Enter Name: ");
				String name, address;
				name = sc.next();
				writer.write(name + "\t");
				System.out.print("Enter Address: ");
				address = sc.next();
				writer.write(address+"\n");
			}
			System.out.println("Written to file successfully");
			writer.close(); // close the fileReader

		} catch (IOException e) {
			System.out.println("Unable to write.");
			e.printStackTrace();
		}

	}

}
