package Swing;

// imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Id_Password {
	public static void main(String[] args) {
		// frame objects
		JFrame frame = new JFrame("Login Application");
		JLabel name = new JLabel(" Name:");
		JLabel password = new JLabel("Password: ");
		JButton button = new JButton("Submit");
//        create objects
		JTextField textField = new JTextField();

		JPasswordField passfield = new JPasswordField(); // create for passwordField

		// position set Display
		name.setBounds(10, 20, 150, 30);	// name position
		textField.setBounds(100, 20, 100, 30);	// name field position

		password.setBounds(10, 45, 150, 30);	// Password position
		passfield.setBounds(100, 45, 100, 30);	// password field Position

		button.setBounds(80, 100, 70, 50);	// Button position
		
		// Action Listener to Submit
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		// add to frames
		frame.add(name);
		frame.add(textField);
		frame.add(password);
		frame.add(passfield);
		frame.add(button);

		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.setVisible(true);
	}
}
