package Swing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Button_create extends Frame {

	Button_create() {
		Button b = new Button("Click Here");
		b.setBounds(50, 100, 95, 30);
		add(b);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		
		  // Add a WindowAdapter to handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Perform the desired action when the window is closed
                dispose(); // Close the window
            }
        });


	}

	public static void main(String[] args) {
		new Button_create();
	}
}
