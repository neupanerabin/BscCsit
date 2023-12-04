package student;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Display {

    Display() {

    }

    void show() {
        JFrame displayFrame = new JFrame("Display Data");
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        try {
            FileReader read = new FileReader("../Classroom/src/rabin.txt");
            Scanner reader = new Scanner(read);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                textArea.append(data + "\n");
            }

            read.close();
        } catch (IOException e) {
            System.out.println("Unable to read.");
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        displayFrame.add(scrollPane);
        displayFrame.setSize(400, 300);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setVisible(true);
    }

   
}
