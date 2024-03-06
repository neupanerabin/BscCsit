package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Even extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JLabel l1, l2, l3;

    Even() {
        l1 = new JLabel("num1: ");
        t1 = new JTextField();

        l2 = new JLabel("num2: ");
        t2 = new JTextField();

        l3 = new JLabel("result: ");
        t3 = new JTextField();

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);

        // Use addActionListener on the text fields
        t1.addActionListener(this);
        t2.addActionListener(this);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1, num2, num3;
        num1 = Integer.parseInt(t1.getText());
        num2 = Integer.parseInt(t2.getText());

        // Assuming you want to perform some action when the text fields are changed
        // For example, adding the values and setting the result in t3
        num3 = num1 + num2;
        t3.setText(String.valueOf(num3));
    }

    public static void main(String[] args) {
        new Even();
    }
}
