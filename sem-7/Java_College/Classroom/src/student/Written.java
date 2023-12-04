package student;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Written {

    public void writtens() {
    	
        final JFrame inputFrame = new JFrame("Enter Data");	// frame object create
        JPanel panel = new JPanel();	// panel object create
        
        // id position
        JLabel studentIdLabel = new JLabel("Student ID:");	// id label
        studentIdLabel.setBounds(10, 20, 80, 25);

        final JTextField idField = new JTextField();	// id field position
        idField.setBounds(100, 20, 200, 25);
        
        JLabel nameLabel = new JLabel("Name:");	        // Name field
        nameLabel.setBounds(10, 60, 80, 25);

        final JTextField nameField = new JTextField();	// name area 
        nameField.setBounds(100, 60, 200, 25);			// name position

        JLabel addressLabel = new JLabel("Address:");	// address position
        addressLabel.setBounds(10, 100, 80, 25);		

        final JTextField addressField = new JTextField();	// address Field and position
        addressField.setBounds(100, 100, 200, 25);

        // Button create 
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 140, 100, 25);

        // Submit button actions
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String id = idField.getText();
                String name = nameField.getText();
                String address = addressField.getText();
                writeToFile(id,name, address);
                inputFrame.dispose();
            }
        });
        // Add to the panel
        panel.setLayout(null);
        panel.add(studentIdLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(submitButton);

        // panel add to the frame
        inputFrame.add(panel);
        inputFrame.setSize(350, 220);	// size of frame
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// exit on close
        inputFrame.setVisible(true);	// make frame visible
    }
    
    // Write inside the files
    private void writeToFile(String id,String name, String address) {
        try {
        	// write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("../Classroom/src/rabin.txt", true));
            writer.write("\t"+id);
            writer.write( "\t"+name + "\t" + address + "\n");
            JOptionPane.showMessageDialog(null, "Written to file successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            writer.close();	// close the writer
        } catch (IOException e) {
            System.out.println("Unable to write.");
            e.printStackTrace();
        }
    }
}
