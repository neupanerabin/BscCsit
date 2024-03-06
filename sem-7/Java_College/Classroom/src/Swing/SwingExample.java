package Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingExample extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1;
    JPanel panel;

    public SwingExample() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("Principal:");
        t1 = new JTextField(10);

        l2 = new JLabel("Time:");
        t2 = new JTextField(10);

        l3 = new JLabel("Rate:");
        t3 = new JTextField(10);

        b1 = new JButton("Calculate Simple Interest");
        b1.addActionListener(this);

        l4 = new JLabel("Simple Interest:");
        t4 = new JTextField(10);
        t4.setEditable(false);

        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(t3);
        panel.add(b1);
        panel.add(new JLabel()); // Spacer
        panel.add(l4);
        panel.add(t4);

        add(panel);

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                double principal = Double.parseDouble(t1.getText());
                double time = Double.parseDouble(t2.getText());
                double rate = Double.parseDouble(t3.getText());
                double simpleInterest = (principal * time * rate) / 100;
                t4.setText(String.valueOf(simpleInterest));
            } catch (NumberFormatException ex) {
                t4.setText("Invalid input");
            }
        }
    }

    public static void main(String args[]) {
        new SwingExample();
    }
}


