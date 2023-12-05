package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Main implements ActionListener {

	public static void main(String[] args) {

		// implement JFrame
		// implement JButton
		JFrame frame = new JFrame(); // frame object create
		JButton written = new JButton("1. Enter ");
		JButton displays = new JButton("2. Display ");
		JButton exit = new JButton("3. exit ");

		// Set positions of Buttons
		written.setBounds(100, 30, 150, 30);
		displays.setBounds(100, 60, 150, 30);
		exit.setBounds(100, 90, 150, 30);

		// Buttons add in the frame
		frame.add(written);
		frame.add(displays);
		frame.add(exit);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close on exit
		frame.setSize(350, 300); // frame size
		frame.setLayout(null);

		final Written writen = new Written(); // Create objects of written class
		final Display display = new Display(); // Create objects of written class

		// Implements the action Listener to write class
		written.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This method will be called when the button is clicked
				writen.writtens();
//				writen.write();
			}
		});

		// Call to display file
		displays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This method will be called when the button is clicked
				display.show();
			}
		});

		// default to close the operation
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		frame.setVisible(true); // make the frame visible

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * --> required to provide an implementation for the actionPerformed method. This
		 * method is called automatically by the Swing framework when the associated
		 * event (in this case, a button click) occurs.
		 */

	}

}
