package Swing;

// imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaGui {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Greeting Application");
		JLabel label = new JLabel(" Name:");
//        create objects
		final JTextField textField = new JTextField();
		final JLabel resultLabel = new JLabel();

		// position set Display
		label.setBounds(10, 20, 150, 30);
		textField.setBounds(170, 20, 100, 30);
		resultLabel.setBounds(10, 70, 300, 30);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				resultLabel.setText("Hello, " + name + "!");
			}
		});
		// add to frames
		frame.add(label);
		frame.add(textField);
		frame.add(resultLabel);

		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}
}
