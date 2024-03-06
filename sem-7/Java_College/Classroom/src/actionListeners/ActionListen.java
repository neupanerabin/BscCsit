package actionListeners;

import javax.swing.*;
import java.awt.event.*;

public class ActionListen extends JFrame {

    JTextField t1, t2, t3;
    JLabel l1, l2, l3;

    ActionListen() {
        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        l1 = new JLabel("num1: ");
        t1 = new JTextField(10);
        l2 = new JLabel("num2: ");
        t2 = new JTextField(10);
        l3 = new JLabel("Result: ");
        t3 = new JTextField(10);
        t3.setEditable(false); // Make result field read-only

        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(t3);
        add(panel);

        t1.addMouseListener(new SummDiff());
        t2.addMouseListener(new SummDiff());


        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class SummDiff extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            try {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int result = num1 + num2;
                t3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                t3.setText("Invalid input");
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            try {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int result = num1 - num2;
                t3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                t3.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        new ActionListen();
    }
}
